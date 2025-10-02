package com.example.bookingservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;   // يربط بالمستخدم
    private Long gymId;    // يربط بالنادي
    private String date;   // تاريخ الحجز
}
