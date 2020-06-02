package de.foodorder.resources;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.foodorder.model.Order;
import de.foodorder.repo.OrderRepo;


@RestController
public class OrderController {

	@Autowired
	private OrderRepo repository;
	
	@PostMapping("/addOrder")
	public String saveOrder(@RequestBody Order order) {
		repository.save(order);
		return "Added Order with id : " + order.getId();
		
	}
	
	@PostMapping("/findAll")
	public List<Order> getOrders(){ 
		return repository.findAll();
		
	}
	
	@PostMapping("/findbyID/{id}")
	public Optional<Order> getOrder(@PathVariable int id){ 
		return repository.findById(id);
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteOrders(@PathVariable int id){ 
		repository.deleteById(id);
		return "Diese Bestellung würde gelöcht : " + id;
		
	}
}
