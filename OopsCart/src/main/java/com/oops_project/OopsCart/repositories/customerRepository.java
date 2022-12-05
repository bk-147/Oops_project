package com.oops_project.OopsCart.repositories;

import com.oops_project.OopsCart.models.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface customerRepository extends MongoRepository<Customer, String> {
}
