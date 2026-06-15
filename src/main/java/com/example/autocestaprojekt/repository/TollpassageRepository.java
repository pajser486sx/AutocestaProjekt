package com.example.autocestaprojekt.repository;

import com.example.autocestaprojekt.model.Tollpassage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TollpassageRepository extends JpaRepository<Tollpassage, Long> {

    List<Tollpassage> findByTollboothId(Long tollboothId);

    List<Tollpassage> findByCarId(Long carId);
}