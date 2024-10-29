package org.softgraf.ecommerce.productserver.model;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Product id should not be null")
        Integer productId,
        @NotNull(message = "Quantity is mandatory")
        double quantity
) {}
