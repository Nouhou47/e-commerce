package org.softgraf.ecommerce.orderserver.orderline;

public record OrderLineResponse(
        Integer id,
        double quantity
) {
}
