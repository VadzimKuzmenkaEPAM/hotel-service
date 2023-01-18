package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Table(name = "rooms")
public class Room {
    @Id
    private String roomNumber;
    @Column(name = "number_of_beds")
    private int numberOfBeds;
    private boolean wifi;
    @Column(name = "free_parking")
    private boolean freeParking;
    private boolean conditioner;
    private boolean fridge;
    @Column(name = "no_smoking_room")
    private boolean noSmokingRoom;
    private boolean breakfast;
    private String comment;
    private BigDecimal cost;
    private boolean free;

    public Room(String roomNumber, int numberOfBeds, boolean wifi, boolean freeParking, boolean conditioner, boolean fridge, boolean noSmokingRoom, boolean breakfast, String comment, BigDecimal cost, boolean free) {
        this.roomNumber = roomNumber;
        this.numberOfBeds = numberOfBeds;
        this.wifi = wifi;
        this.freeParking = freeParking;
        this.conditioner = conditioner;
        this.fridge = fridge;
        this.noSmokingRoom = noSmokingRoom;
        this.breakfast = breakfast;
        this.comment = comment;
        this.cost = cost;
        this.free = free;
    }

    public Room() {
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isFreeParking() {
        return freeParking;
    }

    public void setFreeParking(boolean freeParking) {
        this.freeParking = freeParking;
    }

    public boolean isConditioner() {
        return conditioner;
    }

    public void setConditioner(boolean conditioner) {
        this.conditioner = conditioner;
    }

    public boolean isFridge() {
        return fridge;
    }

    public void setFridge(boolean fridge) {
        this.fridge = fridge;
    }

    public boolean isNoSmokingRoom() {
        return noSmokingRoom;
    }

    public void setNoSmokingRoom(boolean noSmokingRoom) {
        this.noSmokingRoom = noSmokingRoom;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public boolean isFree() {
        return free;
    }

    public void setFree(boolean free) {
        this.free = free;
    }
}