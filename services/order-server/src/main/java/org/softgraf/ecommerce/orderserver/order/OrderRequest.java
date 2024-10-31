package org.softgraf.ecommerce.orderserver.order;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.softgraf.ecommerce.orderserver.product.PurchaseRequest;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequest (
        Integer id,
        String reference,
        @Positive(message = "Order amount should be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method should de precised")
        PaymentMethod paymentMethod,
        @NotNull(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        String customerId,
        @NotEmpty(message = "You should at least purchase one product")
        List<PurchaseRequest> products
){}







