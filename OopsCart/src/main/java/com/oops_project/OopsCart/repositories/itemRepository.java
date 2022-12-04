package com.oops_project.OopsCart.repositories;

import com.oops_project.OopsCart.models.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface itemRepository extends MongoRepository<Item, String> {
}
