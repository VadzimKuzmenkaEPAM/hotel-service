package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Table(name = "rooms_1", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "wifi")
    private Boolean wifi;
    @Column(name = "free_parking")
    private Boolean freeParking;
    @Column(name = "conditioner")
    private Boolean conditioner;
    @Column(name = "fridge")
    private Boolean fridge;
    @Column(name = "no_smoking_room")
    @Getter
    private Boolean noSmokingRoom;
    @Column(name = "breakfast")
    private Boolean breakfast;
    @Column(name = "cost")
    private Double cost;
    @Column(name = "comment")
    private String comment;
    @Column(name = "number_of_beds")
    @Min(value = 1)
    @Max(value = 10)
    private int numberOfBeds;
    @Column(name = "free")
    private Boolean free;
    @Column (name = "room_number")
    private int roomNumber;
}