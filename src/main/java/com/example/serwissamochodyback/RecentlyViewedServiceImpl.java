package com.example.serwissamochodyback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecentlyViewedServiceImpl implements RecentlyViewedService {
    private final RecentlyViewedRepository recentlyViewedRepository;

    private final CarService carService;
    private List<Car> recentlyViewedCars = new ArrayList<>();

    @Autowired
    public RecentlyViewedServiceImpl(RecentlyViewedRepository recentlyViewedRepository, CarService carService) {
        this.recentlyViewedRepository = recentlyViewedRepository;
        this.carService = carService;
    }
    @Override
    public List<Car> getSimilarCarsByMarkaIncludingAdded(String marka) {

        List<Car> similarCars = new ArrayList<>();

        for (Car recentlyViewedCar : recentlyViewedCars) {
            if (recentlyViewedCar.getMarka().equalsIgnoreCase(marka)) {
                similarCars.add(recentlyViewedCar);
            }
        }

        List<Car> carsFromDatabase = carService.getCarsByMarka(marka);
        carsFromDatabase.removeIf(car -> recentlyViewedCars.contains(car));
        similarCars.addAll(carsFromDatabase);

        return similarCars;
    }

    @Override
    public List<Car> getRecentlyViewedCars() {
        return recentlyViewedCars;
    }

    @Override
    public Car getCarById(Long id) {
        return carService.getCarById(id);
    }

    @Override
    public void addCarToRecentlyViewed(Car car) {
        recentlyViewedCars.add(car);

        List<Car> carsWithSameMarka = carService.getCarsByMarka(car.getMarka());

        carsWithSameMarka.remove(car);

        recentlyViewedCars.addAll(carsWithSameMarka);

        if (recentlyViewedCars.size() > 10) {
            recentlyViewedCars = recentlyViewedCars.subList(recentlyViewedCars.size() - 10, recentlyViewedCars.size());
        }
    }
}
