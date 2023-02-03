package com.example.demo.service;

import com.example.demo.model.Booking;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BookingService {
    Booking save(Booking booking);

    Optional<Booking> findById(Long id);

    List<Booking> findAll();

    Double calculateBookingCost(int numberOfDays, double cost);

    public Double recalculationToCorrectCurrency(String currency, Double price);

    public void calculateFinalPrice(Booking booking);
}