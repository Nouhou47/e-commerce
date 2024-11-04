package org.softgraf.ecommerce.orderserver.order;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.softgraf.ecommerce.orderserver.customer.CustomerClient;
import org.softgraf.ecommerce.orderserver.exception.BusinessException;
import org.softgraf.ecommerce.orderserver.kafka.OrderConfirmation;
import org.softgraf.ecommerce.orderserver.kafka.OrderProducer;
import org.softgraf.ecommerce.orderserver.orderline.OrderLine;
import org.softgraf.ecommerce.orderserver.orderline.OrderLineRequest;
import org.softgraf.ecommerce.orderserver.orderline.OrderLineService;
import org.softgraf.ecommerce.orderserver.product.ProductClient;
import org.softgraf.ecommerce.orderserver.product.PurchaseRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository repository;
    private final OrderLineService orderLineService;
    private final CustomerClient  customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderProducer orderProducer;

    public Integer createOrder(OrderRequest request) {
        // check if the customer exists
        var customerOrder = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order :: " +
                        "No customer exist with the provided id: " + request.customerId()));

        // purchase the product --> product-ms
        var purchasedProducts = this.productClient.purchasedProducts(request.products());

        // persist order
        var order = this.repository.save(mapper.toOrder(request));

        //persist order line
        for(PurchaseRequest purchaseRequest: request.products()) {
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        // todo start the payment process

        // send the order confirmation --> notification ms (kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        request.reference(),
                        request.amount(),
                        request.paymentMethod(),
                        customerOrder,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::fromOrder)
                .collect(Collectors.toList());
    }

    public OrderResponse findById(Integer orderId) {
        return repository.findById(orderId)
                .map(mapper::fromOrder)
                .orElseThrow(() -> new EntityNotFoundException(String.format("No Order found with ID: %d", orderId)));
    }
}











