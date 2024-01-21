package com.example.serwissamochodyback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class CarService {

    private final CarRepo carRepo;
    private final UserRepository userRepository;

    private final PurchasedCarRepo purchasedCarRepo;

    @Autowired
    public CarService(CarRepo carRepo, UserRepository userRepository, PurchasedCarRepo purchasedCarRepo) {
        this.carRepo = carRepo;
        this.userRepository = userRepository;
        this.purchasedCarRepo = purchasedCarRepo;
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
    public List<Car> getRandomCars() {
        List<Car> allCars = carRepo.findAll();
        int totalCars = allCars.size();
        int numberOfRandomCars = 5; // Adjust this based on your requirements

        Random random = new Random();
        List<Car> randomCars = new ArrayList<>();

        for (int i = 0; i < numberOfRandomCars && i < totalCars; i++) {
            int randomIndex = random.nextInt(totalCars);
            Car randomCar = allCars.get(randomIndex);
            randomCars.add(randomCar);
        }

        return randomCars;
    }
    public boolean buyCar(Long id, Long userId) {
        Car carToBuy = carRepo.findById(id).orElse(null);
        User user = userRepository.findById(userId).orElse(null);

        if (carToBuy == null || !carToBuy.isDostepny() || user == null) {
            // Samochód nie istnieje, nie jest dostępny do zakupu, lub użytkownik nie istnieje
            return false;
        }

        // Tutaj można dodać logikę dodatkową, np. potwierdzenie płatności, itp.

        // Po udanej transakcji ustawiamy samochód jako niedostępny
        carToBuy.setDostepny(true);
        carRepo.save(carToBuy);

        // Dodaj nowy rekord w tabeli PurchasedCar
        PurchasedCar purchasedCar = new PurchasedCar();
        purchasedCar.setCar(carToBuy);
        purchasedCar.setUser(user);
        purchasedCar.setPurchaseDate(new Date());
        // Ustaw inne informacje, jeśli są dostępne

        purchasedCarRepo.save(purchasedCar);

        return true;
    }
    public List<Car> getCarsByModel(String model) {
        return carRepo.findByModel(model);
    }

    public List<Car> getCarsByRok(int rok) {
        return carRepo.findByRok(rok);
    }


}
