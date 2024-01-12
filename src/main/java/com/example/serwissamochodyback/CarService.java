package com.example.serwissamochodyback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarService {

    private final CarRepo carRepo;

    @Autowired
    public CarService(CarRepo carRepo) {
        this.carRepo = carRepo;
    }

    public List<Car> getAllCars() {
        return carRepo.findAll();
    }

    public Car getCarById(Long id) {
        return carRepo.findById(id).orElse(null);
    }

    public Car saveCar(Car car) {
        return carRepo.save(car);
    }

    public void deleteCar(Long id) {
        carRepo.deleteById(id);
    }

    public List<Car> getCarsByMarka(String marka) {
        return carRepo.findByMarka(marka);
    }

    public List<Car> getCarsByCenaLessThanEqual(double cena) {
        return carRepo.findByCenaLessThanEqual(cena);
    }

    public List<Car> getCarsByModel(String model) {
        return carRepo.findByModel(model);
    }

    public List<Car> getCarsByRok(int rok) {
        return carRepo.findByRok(rok);
    }


}
