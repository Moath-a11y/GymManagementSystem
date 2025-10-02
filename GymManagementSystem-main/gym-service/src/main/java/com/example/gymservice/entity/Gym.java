// Gym.java
package com.example.gymservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "gyms")
@Data
public class Gym {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String location;
}
