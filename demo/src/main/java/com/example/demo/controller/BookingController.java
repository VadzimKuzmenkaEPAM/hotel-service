package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;
    private final RoomService roomService;

    @Autowired
    public BookingController(BookingService bookingService, RoomService roomService) {
        this.bookingService = bookingService;
        this.roomService = roomService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Booking>> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookingService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Booking> create(@RequestBody Booking booking) {
        return ResponseEntity.status(HttpStatus.OK).body(bookingService.save(booking));
    }
}