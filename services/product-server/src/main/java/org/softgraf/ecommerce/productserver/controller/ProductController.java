package org.softgraf.ecommerce.productserver.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.softgraf.ecommerce.productserver.model.ProductPurchaseRequest;
import org.softgraf.ecommerce.productserver.model.ProductPurchaseResponse;
import org.softgraf.ecommerce.productserver.model.ProductRequest;
import org.softgraf.ecommerce.productserver.model.ProductResponse;
import org.softgraf.ecommerce.productserver.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping()
    public ResponseEntity<Integer> createProduct(
            @RequestBody ProductRequest request
    ) {
        return ResponseEntity.ok(service.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
        @RequestBody List<ProductPurchaseRequest> request
    ) {
        return ResponseEntity.ok(service.purchaseProduct(request));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable("product-id") Integer productId
    ) {
        return ResponseEntity.ok(service.findById(productId));
    }

    @GetMapping("/")
    public ResponseEntity<List<ProductResponse>> findAll(
    ) {
        return ResponseEntity.ok(service.findAll());
    }
}
