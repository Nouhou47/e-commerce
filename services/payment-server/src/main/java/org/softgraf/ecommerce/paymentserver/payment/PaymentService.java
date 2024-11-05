package org.softgraf.ecommerce.paymentserver.payment;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.softgraf.ecommerce.paymentserver.notification.NotificationProducer;
import org.softgraf.ecommerce.paymentserver.notification.PaymentNotificationRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;
    private final PaymentMapper mapper;
    private final NotificationProducer notificationProducer;

    public Integer createPayment(@Valid PaymentRequest request) {
        var payment = repository.save(mapper.toPayment(request));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference().toString(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstName(),
                        request.customer().lastName(),
                        request.customer().email()
                        )
        );

        return payment.getId();
    }
}








