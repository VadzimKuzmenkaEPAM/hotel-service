package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column
    @NotBlank
    private String name;
    @Column
    @Min(value = 1)
    @Max(value = 365)
    private int duration;
    @Column
    private Double cost;
    @Column
    private String currency;
    @Column
    private LocalDateTime date;
    @Column(name = "room_number")
    private int roomNumber;
    @Column(name = "start_booking")
    private LocalDate startBooking;
    @Column(name = "finish_booking")
    private LocalDate finishBooking;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    Customer customer;

    @PrePersist
    public void prePersist() {
        this.date = LocalDateTime.now();
        this.finishBooking = startBooking.plusDays(this.duration);
    }
}