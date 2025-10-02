package com.example.bookingservice.controller;

import com.example.bookingservice.dto.BookingResponse;
import com.example.bookingservice.entity.Booking;
import com.example.bookingservice.repository.BookingRepository;
import com.example.bookingservice.service.ExternalServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ExternalServiceClient externalClient;

    // إنشاء حجز جديد (يحفظ userId, gymId, date فقط)
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingRepository.save(booking);
    }

    // استرجاع كل الحجوزات (خام بدون تفاصيل)
    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // استرجاع حجز واحد بالتفاصيل المجمعة
    @GetMapping("/{id}")
    public BookingResponse getBookingById(@PathVariable Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        // استدعاء الخدمات الخارجية
        var user = externalClient.getUserById(booking.getUserId());
        var gym = externalClient.getGymById(booking.getGymId());

        return BookingResponse.fromBookingAndDetails(booking, user, gym);
    }
}
