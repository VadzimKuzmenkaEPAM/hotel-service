package com.example.demo.service;

import com.example.demo.model.Room;

import java.util.List;

public interface RoomService {
    Room save(Room room);

    Room update(Room room, int id);

    Room readByRoomNumber(int number);

    List<Room> findFreeNumber (boolean free);

    void takeRoom(int number);

    public Room updateEntityField(Room room, int roomNumber);

    void detach(Room room);
}