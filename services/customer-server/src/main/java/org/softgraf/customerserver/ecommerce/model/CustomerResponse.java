package org.softgraf.customerserver.ecommerce.model;

import org.softgraf.customerserver.ecommerce.entity.Address;

public record CustomerResponse(
    String id,
    String firstname,
    String lastname,
    String email,
    Address address
) {}
