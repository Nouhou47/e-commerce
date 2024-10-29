package org.softgraf.ecommerce.productserver.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.softgraf.ecommerce.productserver.exception.ProductPurchaseException;
import org.softgraf.ecommerce.productserver.mapper.ProductMapper;
import org.softgraf.ecommerce.productserver.model.ProductPurchaseRequest;
import org.softgraf.ecommerce.productserver.model.ProductPurchaseResponse;
import org.softgraf.ecommerce.productserver.model.ProductRequest;
import org.softgraf.ecommerce.productserver.model.ProductResponse;
import org.softgraf.ecommerce.productserver.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public Integer createProduct(ProductRequest request) {
        var product = mapper.toProduct(request);
        return repository.save(product).getId();
    }

    public ArrayList<ProductPurchaseResponse> purchaseProduct(List<ProductPurchaseRequest> request) {
         var productIds = request.stream()
                 .map(ProductPurchaseRequest::productId)
                 .toList();
         var storedProducts = repository.findAllByIdInOrderById(productIds);
         if (productIds.size() != storedProducts.size()) {
             throw new ProductPurchaseException("One or more product does not exists in your order");
         }

         var storedRequests = request
                 .stream()
                 .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                 .toList();
         var purchasedProducts = new ArrayList<ProductPurchaseResponse>();
         for(int i = 0; i < storedProducts.size(); i++) {
             var product = storedProducts.get(i);
             var productRequest = storedRequests.get(i);
             if (product.getAvailableQuantity() < productRequest.quantity()) {
                 throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
             }
             var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
             product.setAvailableQuantity(newAvailableQuantity);
             repository.save(product);
             purchasedProducts.add(mapper.toProductPurchasedResponse(product, productRequest.quantity()));
         }

         return purchasedProducts;
    }

    public ProductResponse findById(Integer productId) {
        return repository.findById(productId)
                .map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Product not found with id: %s", productId)));
    }

    public List<ProductResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }
}
