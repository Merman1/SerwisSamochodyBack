package com.example.serwissamochodyback;

import org.springframework.beans.factory.annotation.Autowired;
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


}
