package de.foodorder.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import de.foodorder.model.Order;

public interface OrderRepo extends MongoRepository<Order, Integer>{

}
