package com.example.serwissamochodyback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PurchasedCarRepo extends JpaRepository<PurchasedCar,Long> {

}

