package org.softgraf.customerserver.ecommerce.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.softgraf.customerserver.ecommerce.entity.Address;

public record CustomerRequest(

        String id,
        @NotNull(message = "Customer firstname is required")
        String firstname,
        @NotNull(message = "Customer lastname is required")
        String lastname,
        @NotNull(message = "Customer email is required")
        @Email(message = "Customer firstname is required")
        String email,
        Address address
) {
}
