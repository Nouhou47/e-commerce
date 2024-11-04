package org.softgraf.ecommerce.orderserver.kafka;

import org.softgraf.ecommerce.orderserver.customer.CustomerResponse;
import org.softgraf.ecommerce.orderserver.order.PaymentMethod;
import org.softgraf.ecommerce.orderserver.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {}
