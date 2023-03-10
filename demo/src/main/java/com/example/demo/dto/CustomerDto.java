package com.example.demo.dto;

import com.example.demo.model.Booking;
import lombok.*;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private Long id;
    private String login;
    private String password;
    private String role;
    private String name;
    private String surname;
    private String email;
    private String cardNumber;
    Set<Booking> bookings;

    public CustomerDto(Long id, String login, String password, String role, String name,
                       String surname, String email, String cardNumber) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.cardNumber = cardNumber;
    }
}
