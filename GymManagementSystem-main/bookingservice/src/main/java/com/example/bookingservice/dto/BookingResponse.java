package com.example.bookingservice.dto;

import com.example.bookingservice.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponse {
    private Long id;
    private UserDto user;
    private GymDto gym;
    private String date;

    public static BookingResponse fromBookingAndDetails(Booking b, UserDto user, GymDto gym) {
        return new BookingResponse(b.getId(), user, gym, b.getDate());
    }
}
