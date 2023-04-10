package animalapi.controller;

import animalapi.model.Order;
import animalapi.service.AnimalServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api")
public class OrderController {
    private Logger logger = LoggerFactory.getLogger(OrderController.class);
    private AnimalServiceImpl animalService;
    public OrderController(AnimalServiceImpl orderService) {
        this.animalService = orderService;
    }

    // CRUD endpoint follows

    // http://localhost:8090/api/animals
    @PostMapping("/animals")
    public ResponseEntity<Object> createOrder(@RequestBody Order order){
        try {
            Order createdOrder = animalService.create(order);
            return new ResponseEntity<Object>(createdOrder, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/animals")
    public ResponseEntity<Object> getAllOrders(){
        try {
            Iterable<Order> orders = animalService.findAllItr();
            return new ResponseEntity<Object>(orders, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    //@GetMapping("/animals/{id}")  // can include MediaType as well
    @GetMapping(value="/animals/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getOrderById(@PathVariable("id") Long id){
        try {
            Optional<Order> order = animalService.findById(id);
            if (order.isPresent()) {
                return new ResponseEntity<Object>(order.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/animals/{id}")
    public ResponseEntity<Object> updateOrder(@PathVariable("id") Long id, @RequestBody Order order){
        try {
            order.setId(id);
            Order savedOrder = animalService.update(order);
            return new ResponseEntity<Object>(savedOrder, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<Object>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/animals/{id}")
    public ResponseEntity<HttpStatus> deleteOrder(@PathVariable("id") Long id){
        try {
            animalService.deleteById(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage(), ex);
            return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
        }
    }
}