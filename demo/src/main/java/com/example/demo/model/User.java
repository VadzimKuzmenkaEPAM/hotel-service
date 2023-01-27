package com.example.demo.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String login;
    @Column
    private String password;
    @Column
    private String role;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    @Email
    private String email;
    @Column
    @Pattern(regexp = "\\d{4}-\\d{4}-\\d{4}-\\d{4}")
    private String cardNumber;
    @OneToMany(mappedBy = "booking")
    List<Booking> bookings;

}
