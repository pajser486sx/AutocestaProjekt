package com.example.autocestaprojekt.repository;

import com.example.autocestaprojekt.model.Car;
import com.example.autocestaprojekt.model.Road;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoadRepository extends JpaRepository<Road, Long> {

    // Optional<Road> findById(Long id);

    Optional<Road> findByOznaka(Road.Oznaka oznaka);

}
