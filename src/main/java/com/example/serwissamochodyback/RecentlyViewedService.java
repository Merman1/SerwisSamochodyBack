package com.example.serwissamochodyback;

import java.util.List;

public interface RecentlyViewedService {

    List<Car> getRecentlyViewedCars();

    List<Car> getSimilarCarsByMarkaIncludingAdded(String marka);

    Car getCarById(Long id);

    void addCarToRecentlyViewed(Car car);
}
