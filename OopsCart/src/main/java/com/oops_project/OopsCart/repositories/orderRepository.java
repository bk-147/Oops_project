package com.oops_project.OopsCart.repositories;

import com.oops_project.OopsCart.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface orderRepository extends MongoRepository<Order, String> {
}
