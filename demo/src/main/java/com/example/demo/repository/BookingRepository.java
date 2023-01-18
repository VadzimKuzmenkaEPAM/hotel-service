package com.example.demo.repository;

import com.example.demo.model.Booking;
import org.springframework.stereotype.Repository;
@Repository
public interface BookingRepository {
    Booking create(Booking booking);

    Booking update(Booking booking);

    void delete(Long id);

    Booking readById(Long id);
}