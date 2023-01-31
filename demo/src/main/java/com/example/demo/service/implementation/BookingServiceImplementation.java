package com.example.demo.service.implementation;

import com.example.demo.exceptions.AppException;
import com.example.demo.exceptions.ErrorCode;
import com.example.demo.model.Booking;
import com.example.demo.repository.BookingRepository;
import com.example.demo.service.BookingService;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImplementation implements BookingService {
    private static final Double LARI_TO_DOLLAR_EXCHANGE_RATE = 2.65;
    private static final Double BYN_TO_DOLLAR_EXCHANGE_RATE = 2.53;
    private static final String BYN_CURRENCY = "BYN";
    private static final String LARI_CURRENCY = "LARI";

    private final BookingRepository bookingRepository;
    private final RoomService roomService;

    @Autowired
    public BookingServiceImplementation(BookingRepository bookingRepository, RoomService roomService) {
        this.bookingRepository = bookingRepository;
        this.roomService = roomService;
    }

    @Override
    public Booking save(Booking booking) {
        roomService.takeRoom(booking.getRoomNumber());
        calculateFinalPrice(booking);
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> findById(Long id) {
        return Optional.of(bookingRepository.findById(id).
                orElseThrow(() -> new AppException(ErrorCode.BOOKING_NOT_FOUND)));
    }

    @Override
    public Double calculateBookingCost(int numberOfDays, double cost) {
        return numberOfDays * cost;
    }

    @Override
    public Double recalculationToCorrectCurrency(String currency, Double dollarPrice) {
        Double price = dollarPrice;
        if (currency.equals(BYN_CURRENCY)) {
            price = dollarPrice * BYN_TO_DOLLAR_EXCHANGE_RATE;
        } else if (currency.equals(LARI_CURRENCY)) {
            price = dollarPrice * LARI_TO_DOLLAR_EXCHANGE_RATE;
        }
        return price;
    }

    @Override
    public void calculateFinalPrice(Booking booking) {
        Double finalPrice = recalculationToCorrectCurrency(booking.getCurrency(), calculateBookingCost(booking.getDuration(),
                roomService.readByRoomNumber(booking.getRoomNumber()).getCost()));
        booking.setCost(finalPrice);
    }
}