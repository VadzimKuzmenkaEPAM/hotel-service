package com.example.demo.repository;

import com.example.demo.model.Booking;
import com.example.demo.model.Room;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookingRepository extends CrudRepository <Booking, Long> {
}