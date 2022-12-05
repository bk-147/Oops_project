package com.oops_project.OopsCart.repositories;

import com.oops_project.OopsCart.models.admin;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRepository extends MongoRepository<admin, String> {
}
