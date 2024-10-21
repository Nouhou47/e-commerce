package org.softgraf.customerserver.ecommerce.repository;

import org.softgraf.customerserver.ecommerce.entity.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
