package animalapi.repository;

import animalapi.model.Animal;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class AnimalRepository {
    private static final Map<Long, Animal> orderMap = new HashMap<>();
    static {
        initDataSource();
    }

    private static void initDataSource() {
        Animal o1 = new Animal(1L, "Cow", 2, "24 03 2023");
        Animal o2 = new Animal(2L, "Deer", 34, "24 03 2023");
        Animal o3 = new Animal(3L, "Bunny", 22, "24 03 2023");

        orderMap.put(o1.getRegNo(), o1);
        orderMap.put(o2.getRegNo(), o2);
        orderMap.put(o3.getRegNo(), o3);
    }

    // CRUD operations (later we inherit from interface ()CrudRepo or JpaRepo)

    // C - Create
    public Animal save(Animal o){
        orderMap.put(o.getRegNo(), o);
        return o;
    }

    // R - GET
    public Animal findById(Long id) {
        return orderMap.get(id);
    }

    // U - Update
    public Animal update(Animal o){
        // saves the object
        orderMap.put(o.getRegNo(), o);
        return o;
    }
    // D - Delete
    public void deleteById(Long id) { // void just for test
        orderMap.remove(id);
    }

    // R - find all
    public List<Animal> findAll() {
        Collection<Animal> c = orderMap.values();
        List<Animal> orderList = new ArrayList<>();
        orderList.addAll(c);
        return orderList;
    }
}
