package org.softgraf.customerserver.ecommerce.mapper;

import org.softgraf.customerserver.ecommerce.entity.Address;
import org.softgraf.customerserver.ecommerce.entity.Customer;
import org.softgraf.customerserver.ecommerce.model.CustomerRequest;
import org.softgraf.customerserver.ecommerce.model.CustomerResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomer(CustomerRequest request) {
        if (request == null) return null;
        return Customer.builder()
                .id(request.id())
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .address(request.address())
                .build();
    }

    public CustomerResponse fromCustomer(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
