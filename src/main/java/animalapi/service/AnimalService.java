package animalapi.service;

import animalapi.model.Order;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service // shorthand for @Bean to register AnimalService interface as a bean
public interface AnimalService {
    Order create(Order order);
    List<Order> findAll();  //  use List or Iterable
    Iterable<Order> findAllItr(); // use List or Iterable
    Optional<Order> findById(Long id);
    Order update(Order order);
    void deleteById(Long id);
}