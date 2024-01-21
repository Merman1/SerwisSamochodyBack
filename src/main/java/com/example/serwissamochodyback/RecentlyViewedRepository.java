package com.example.serwissamochodyback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RecentlyViewedRepository extends JpaRepository<Car, Long> {

    List<Car> findByMarkaContainingIgnoreCase(String marka);
}

