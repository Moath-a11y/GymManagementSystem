package com.example.gymservice.repository;

import com.example.gymservice.entity.Gym;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GymRepository extends JpaRepository<Gym, Long> {
}
