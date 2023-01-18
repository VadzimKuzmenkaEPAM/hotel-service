package com.example.demo.model;
import javax.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
public class Booking {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @Column
    private String name;
    @Column
    private int duration;
    @Column
    private Double cost;
    @Column
    private String currency;
    @Column
    private LocalDateTime date;
    @Column (name = "number_of_room")
    private String numberOfRoom;

    public Booking(Long id, String name, int duration, Double cost, String currency, LocalDateTime date, String numberOfRoom) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.cost = cost;
        this.currency = currency;
        this.date = date;
        this.numberOfRoom = numberOfRoom;
    }

    public Booking() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNumberOfRoom() {
        return numberOfRoom;
    }

    public void setNumberOfRoom(String numberOfRoom) {
        this.numberOfRoom = numberOfRoom;
    }
}