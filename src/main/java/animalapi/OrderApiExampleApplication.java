package animalapi;


import animalapi.controller.AnimalController;
import animalapi.repository.AnimalRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderApiExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApiExampleApplication.class, args);


        AnimalRepository AnimalRepository = new AnimalRepository();
        AnimalController animalController = new AnimalController(AnimalRepository);
    }

}
