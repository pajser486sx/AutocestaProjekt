package com.example.autocestaprojekt.repository;

import com.example.autocestaprojekt.model.Tollbooth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TollboothRepository extends JpaRepository<Tollbooth, Long> {

    Optional<Tollbooth> findByImeIgnoreCase(String ime);

}