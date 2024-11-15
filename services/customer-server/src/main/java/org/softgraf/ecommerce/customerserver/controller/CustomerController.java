package org.softgraf.ecommerce.customerserver.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.softgraf.ecommerce.customerserver.model.CustomerRequest;
import org.softgraf.ecommerce.customerserver.service.CustomerService;
import org.softgraf.ecommerce.customerserver.model.CustomerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService service;

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok(
                String.format("Hello from Customer MS at %s", LocalDateTime.now(ZoneId.of("UCT")))
        );
    }

    @PostMapping()
    public ResponseEntity<String> createCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        return ResponseEntity.ok(service.createCustomer(request));
    }

    @PutMapping()
    public ResponseEntity<Void> updateCustomer(
            @RequestBody @Valid CustomerRequest request
    ) {
        service.updateCustomer(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping()
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return ResponseEntity.ok(service.findAllCustomers());
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> existsById(@PathVariable("customer-id") String id) {
        return ResponseEntity.ok(service.existById(id));
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("customer-id") String id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> deleteById(@PathVariable("customer-id") String customerId) {
        service.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}













