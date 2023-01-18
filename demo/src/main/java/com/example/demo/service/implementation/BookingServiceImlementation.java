package com.example.demo.service.implementation;

import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.transaction.Transactional;
@EnableTransactionManagement
@Service
public class BookingServiceImlementation implements BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImlementation(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    @Transactional
    public Booking create(Booking booking) {
        return bookingRepository.create(booking);
    }

    @Override
    public Booking update(Booking booking) {
        return null;
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public Booking readById(Long id) {
        return null;
    }
}