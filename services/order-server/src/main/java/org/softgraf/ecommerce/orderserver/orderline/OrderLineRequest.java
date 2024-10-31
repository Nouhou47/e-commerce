package org.softgraf.ecommerce.orderserver.orderline;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        Integer productId,
        Integer quantity
) {}
