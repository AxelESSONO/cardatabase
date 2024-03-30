package com.axel.cardatabase.domain.repositories;

import com.axel.cardatabase.domain.model.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {

    // Fetch cars by brand
    List<Car> findByBrand(String brand);
    // Fetch cars by model
    List<Car> findByModel(String model);
    // Fetch cars by registrationNumber
    List<Car> findByRegistrationNumber(String registrationNumber);
    // Fetch cars by color
    List<Car> findByColor(String color);
    // Fetch cars by model year
    List<Car> findByModelYear(int modelYear);
    // Fetch cars by model year
    List<Car> findByPrice(int price);


    // Fetch cars by brand and model
    List<Car> findByBrandAndModel(String brand, String model);
    // Fetch cars by brand or color
    List<Car> findByBrandOrColor(String brand, String color);
    // Fetch cars by brand and sort by year
    List<Car> findByBrandOrderByModelYearAsc(String brand);

}
