package com.example.serwissamochodyback;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class PurchasedCar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car.id", nullable = false)
    private Car car;

    @ManyToOne
    @JoinColumn(name = "user.id", nullable = false)
    private User user;

    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;

    public PurchasedCar(Long id, Car car, User user, Date purchaseDate) {
        this.id = id;
        this.car = car;
        this.user = user;
        this.purchaseDate = purchaseDate;
    }

    public PurchasedCar() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}

