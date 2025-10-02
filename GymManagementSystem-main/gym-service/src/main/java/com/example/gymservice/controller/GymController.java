package com.example.gymservice.controller;

import com.example.gymservice.entity.Gym;
import com.example.gymservice.repository.GymRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gyms")
public class GymController {

    @Autowired
    private GymRepository gymRepository;

    @PostMapping
    public Gym createGym(@RequestBody Gym gym) {
        return gymRepository.save(gym);
    }

    @GetMapping
    public List<Gym> getAllGyms() {
        return gymRepository.findAll();
    }

    @GetMapping("/{id}")
    public Gym getGymById(@PathVariable Long id) {
        return gymRepository.findById(id).orElseThrow(() -> new RuntimeException("Gym not found"));
    }
}
