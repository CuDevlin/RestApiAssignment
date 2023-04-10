package animalapi.controller;

import animalapi.model.Animal;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import animalapi.repository.AnimalRepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class AnimalController {
    private AnimalRepository animalRepo;

    public AnimalController(AnimalRepository orderRepo) {
        this.animalRepo = orderRepo;
    }

    // @GetMapping see the main controller
    @RequestMapping(value = "/animals/{id}", //
            method = RequestMethod.GET, //
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE} )
    @ResponseBody
    public Animal getAnimalById(@PathVariable Long id) {
        return animalRepo.findById(id);
    }

    @RequestMapping(value = "/animals", //
            method = RequestMethod.GET, //,
    produces = {MediaType.APPLICATION_JSON_VALUE} )
    @ResponseBody
    public List<Animal> getAllAnimals() {
        List<Animal> list = animalRepo.findAll();
        return list;
    }

    @RequestMapping(value = "/animals",
    method = RequestMethod.POST)
    @ResponseBody
    public Animal createAnimal(@RequestBody Animal order) {
        return animalRepo.save(order);
    }
}
