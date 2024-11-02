package com.axel.cardatabase;

import com.axel.cardatabase.domain.model.AppUser;
import com.axel.cardatabase.domain.model.Car;
import com.axel.cardatabase.domain.model.Owner;
import com.axel.cardatabase.domain.repository.AppUserRepository;
import com.axel.cardatabase.domain.repository.CarRepository;
import com.axel.cardatabase.domain.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

    private static final Logger logger = LoggerFactory
            .getLogger(CardatabaseApplication.class);

    private final CarRepository carRepository;
    private final OwnerRepository ownerRepository;
    private final AppUserRepository userRepository;

    public CardatabaseApplication(
            CarRepository carRepository,
            OwnerRepository ownerRepository,
            AppUserRepository userRepository
    ) {

        this.carRepository = carRepository;
        this.ownerRepository = ownerRepository;
        this.userRepository = userRepository;

    }

    public static void main(String[] args) {
        SpringApplication.run(CardatabaseApplication.class, args);
        logger.info("****** Application Started ******");
    }

    @Override
    public void run(String... args) throws Exception {

        // Add owner objects and save these to db
        Owner owner1 = new Owner("John", "Johnson");
        Owner owner2 = new Owner("Mary", "Robinson");

        ownerRepository.saveAll(Arrays.asList(owner1, owner2));

        carRepository.save(
                new Car("Ford",
                        59000,
                        "Kuga",
                        "Blue",
                        "ADF-1121",
                        2023,
                        owner1)
        );

        carRepository.save(
                new Car( "Nissan",
                        35000,
                        "Juke",
                        "Black",
                        "EDT-8956",
                        2021,
                        owner2)
        );

        carRepository.save(
                new Car("Peugeot",
                        27000,
                        "3008",
                        "White",
                        "TOH-8042",
                        2019,
                        owner1)
        );

        // Fetch all cars and log to console
        for (Car car : carRepository.findAll()) {
            logger.info(
                    "brand: {}, model: {}",
                    car.getBrand(),
                    car.getModel()
            );
        }

        // Username : user, password : user
        userRepository.save(new AppUser(
                "user",
                "$2y$10$IB8GMzzjlMab7xFXk8.l..N1FrqxZRjpxhZ9vvto0x9QoGD8KBi2G",
                "USER"));

        // Username : admin, password : admin
        userRepository.save(new AppUser(
                "admin",
                "$2y$10$V6/hTOe6V4B5ooa.j6bU1uRH8jW.6neXVDSC1d7VtMnO5txNZ4VDm",
                "ADMIN"));
    }
}
