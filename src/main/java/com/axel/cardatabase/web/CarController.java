package com.axel.cardatabase.web;

import com.axel.cardatabase.domain.model.Car;
import com.axel.cardatabase.domain.repository.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars")
    public Iterable<Car> getCars(){
        // Fetch and return cars
        return repository.findAll();
    }

}
