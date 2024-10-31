package org.softgraf.ecommerce.orderserver.order;

import lombok.RequiredArgsConstructor;
import org.softgraf.ecommerce.orderserver.customer.CustomerClient;
import org.softgraf.ecommerce.orderserver.exception.BusinessException;
import org.softgraf.ecommerce.orderserver.orderline.OrderLine;
import org.softgraf.ecommerce.orderserver.orderline.OrderLineRequest;
import org.softgraf.ecommerce.orderserver.orderline.OrderLineService;
import org.softgraf.ecommerce.orderserver.product.ProductClient;
import org.softgraf.ecommerce.orderserver.product.PurchaseRequest;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository repository;
    private final OrderLineService orderLineService;
    private final CustomerClient  customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;

    public Integer createOrder(OrderRequest request) {
        // check if the customer exists
        var customerOrder = customerClient.findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException("Cannot create order :: " +
                        "No customer exist with the provided id: " + request.customerId()));

        // purchase the product --> product-ms
        this.productClient.purchasedProducts(request.products());

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


        return null;
    }
}



