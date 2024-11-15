package org.softgraf.ecommerce.orderserver.payment;

import org.softgraf.ecommerce.orderserver.customer.CustomerResponse;
import org.softgraf.ecommerce.orderserver.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
