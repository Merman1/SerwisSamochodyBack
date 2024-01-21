package com.example.serwissamochodyback;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8001", maxAge = 3600)
@RestController
@RequestMapping("/api/auth/recently-viewed")
public class RecentlyViewedController {

    private final RecentlyViewedService recentlyViewedService;

    @Autowired
    public RecentlyViewedController(RecentlyViewedService recentlyViewedService) {
        this.recentlyViewedService = recentlyViewedService;
    }

    @GetMapping
    public List<Car> getRecentlyViewedCars() {
        return recentlyViewedService.getRecentlyViewedCars();
    }

    @PostMapping("/add/{id}")
    public ResponseEntity<String> addCarToRecentlyViewed(@PathVariable Long id) {
        Car car = recentlyViewedService.getCarById(id);

        if (car == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Car not found");
        }

        recentlyViewedService.addCarToRecentlyViewed(car);

        List<Car> similarCarsByMarka = recentlyViewedService.getSimilarCarsByMarkaIncludingAdded(car.getMarka());

        return ResponseEntity.ok(similarCarsByMarka.toString());
    }
}
