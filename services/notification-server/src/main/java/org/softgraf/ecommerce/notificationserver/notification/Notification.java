package org.softgraf.ecommerce.notificationserver.notification;

import lombok.*;
import org.softgraf.ecommerce.notificationserver.kafka.order.OrderConfirmation;
import org.softgraf.ecommerce.notificationserver.kafka.payment.PaymentConfirmation;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Document
public class Notification {

    @Id
    private String id;
    private NotificationType type;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}




