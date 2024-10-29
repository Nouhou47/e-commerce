package org.softgraf.ecommerce.customerserver.model;

import org.softgraf.ecommerce.customerserver.entity.Address;

public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email,
    Address address
) {}
