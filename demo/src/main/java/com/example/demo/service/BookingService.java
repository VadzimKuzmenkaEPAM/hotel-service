package com.example.demo.service;

import com.example.demo.model.Booking;
import org.springframework.stereotype.Service;

@Service
public interface BookingService {
    Booking create(Booking booking);

    Booking update(Booking booking);

    void delete(Long id);

    Booking readById(Long id);
}
