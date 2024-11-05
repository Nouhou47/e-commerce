package org.softgraf.ecommerce.notificationserver.email;

import lombok.Getter;

@Getter
public enum EmailTemplate {
    PAYMENT_CONFIRMATION("payment-confirmation.html", "Payment Successfully processed"),
    ORDER_CONFIRMATION("payment-confirmation.html", "Order Confirmation");

    private final String template;
    private final String subject;

    EmailTemplate(String template, String subject) {
        this.template = template;
        this.subject = subject;
    }
}
