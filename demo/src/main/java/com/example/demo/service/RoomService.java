package com.example.demo.service;

import com.example.demo.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {
    Room save(Room room);

    Room update(Room room, int id);

    Room readByRoomNumber(int number);

    List<Room> findFreeNumber (boolean free);

    void takeRoom(int number);

    public Optional <Room> updateEntityField(Room room, int roomNumber);

    void detach(Optional <Room> room);
}