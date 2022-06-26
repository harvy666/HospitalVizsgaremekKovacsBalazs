package com.example.hospitalvizsgaremek;

import org.flywaydb.core.Flyway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HospitalVizsgaremekApplication {

    public static void main(String[] args) {
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:h2:mem:hospital", "sa", null)
                .locations("db/migration")
                .load();

        flyway.migrate();

        SpringApplication.run(HospitalVizsgaremekApplication.class, args);
    }

}
