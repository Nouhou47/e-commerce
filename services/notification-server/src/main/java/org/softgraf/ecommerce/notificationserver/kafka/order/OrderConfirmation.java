package org.softgraf.ecommerce.notificationserver.kafka.order;

import org.softgraf.ecommerce.notificationserver.kafka.payment.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Customer customer,
        List<Product> products
) {
}
