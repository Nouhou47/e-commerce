package org.softgraf.ecommerce.paymentserver.payment;

import java.math.BigDecimal;

public record PaymentRequest(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        Integer orderReference,
        Customer customer
) {
}
