package com.example.serwissamochodyback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8001", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/cars")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }


    @GetMapping("/{id}")
    public Car getCarById(@PathVariable Long id) {

        return carService.getCarById(id);
    }

    @PostMapping("/save")
    public Car saveCar(@RequestBody Car car) {
        return carService.saveCar(car);
    }

    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
    }

    @GetMapping("/byMarka/{marka}")
    public List<Car> getCarsByMarka(@PathVariable String marka) {
        return carService.getCarsByMarka(marka);
    }
    @GetMapping("/random-cars")
    public List<Car> getRandomCars() {
        return carService.getRandomCars();
    }
    @GetMapping("/byCenaLessThanEqual/{cena}")
    public List<Car> getCarsByCenaLessThanEqual(@PathVariable double cena) {
        return carService.getCarsByCenaLessThanEqual(cena);
    }

    @GetMapping("/byModel/{model}")
    public List<Car> getCarsByModel(@PathVariable String model) {
        return carService.getCarsByModel(model);
    }

    @GetMapping("/byRok/{rok}")
    public List<Car> getCarsByRok(@PathVariable int rok) {
        return carService.getCarsByRok(rok);
    }
    @PostMapping("/buy/{id}")
    public ResponseEntity<String> buyCar(@PathVariable Long id) {
        Car carToBuy = carService.getCarById(id);

        if (carToBuy == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }

        carToBuy.setDostepny(false);
        carService.saveCar(carToBuy);
        return ResponseEntity.ok("Car purchased successfully");
    }


}
