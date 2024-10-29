package org.softgraf.ecommerce.customerserver.service;

import lombok.RequiredArgsConstructor;

import org.apache.commons.lang.StringUtils;
import org.softgraf.ecommerce.customerserver.mapper.CustomerMapper;
import org.softgraf.ecommerce.customerserver.model.CustomerRequest;
import org.softgraf.ecommerce.customerserver.repository.CustomerRepository;
import org.softgraf.ecommerce.customerserver.entity.Customer;
import org.softgraf.ecommerce.customerserver.exception.CustomerNotFoundException;
import org.softgraf.ecommerce.customerserver.model.CustomerResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequest request) {
        var customer = repository.save(mapper.toCustomer(request));
        return customer.getId();
    }

    public void updateCustomer(CustomerRequest request) {
        var customer = repository.findById(request.id())
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("Cannot update customer:: NO customer found with the provided id:: %s", request.id())
        ));
        mergerCustomer(customer, request);
        repository.save(customer);
    }

    private void mergerCustomer(Customer customer, CustomerRequest request) {
        if (StringUtils.isNotBlank((request.lastname()))) {
            customer.setLastname(request.lastname());
        }
        if (StringUtils.isNotBlank((request.firstname()))) {
            customer.setFirstname(request.firstname());
        }
        if (StringUtils.isNotBlank((request.email()))) {
            customer.setEmail(request.email());
        }
        if (request.address() != null) {
            customer.setAddress(request.address());
        }
    }

    public List<CustomerResponse> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existById(String id) {
        return repository.findById(id).isPresent();
    }

    public CustomerResponse findById(String customerId) {
        return repository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(
                        format("No customer found with the provided id:: %s", customerId)
                ));
    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}








