package com.example.demo.service.implementation;

import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;


@Service
public class RoomServiceImplementation implements RoomService {

    private static final boolean TAKE_ROOM = false;
    private static final String LEAVE_THE_ROOM = "true";
    private final RoomRepository roomRepository;
    private final EntityManager entityManager;

    @Autowired
    public RoomServiceImplementation(RoomRepository roomRepository, EntityManager entityManager) {
        this.roomRepository = roomRepository;
        this.entityManager = entityManager;
    }

    @Override
    public Room save(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room readByRoomNumber(int number) {
        return roomRepository.readByRoomNumber(number);
    }

    @Override
    public List<Room> findFreeNumber(boolean free) {
        return roomRepository.findFreeNumber(free);
    }

    @Transactional
    @Override
    public void takeRoom(int number) {
        roomRepository.takeRoom(number, TAKE_ROOM);
    }

    @Override
    public Room update(Room room, int id) {
        return roomRepository.save(room);
    }

    public Room updateEntityField(Room room, int roomNumber) {
        Room roomInDb = roomRepository.readByRoomNumber(roomNumber);
        detach(roomInDb);
        roomInDb.setId(room.getId() != null ? room.getId() :
                readByRoomNumber(roomNumber).getId());
        roomInDb.setWifi(room.getWifi() != null ? room.getWifi() :
                readByRoomNumber(roomNumber).getWifi());
        roomInDb.setFreeParking(room.getFreeParking() != null ? room.getFreeParking() :
                readByRoomNumber(roomNumber).getFreeParking());
        roomInDb.setConditioner(room.getConditioner() != null ? room.getConditioner() :
                readByRoomNumber(roomNumber).getConditioner());
        roomInDb.setFridge(room.getFridge() != null ? room.getFridge() :
                readByRoomNumber(roomNumber).getFridge());
        roomInDb.setNoSmokingRoom(room.getNoSmokingRoom() != null ? room.getNoSmokingRoom() :
                readByRoomNumber(roomNumber).getNoSmokingRoom());
        roomInDb.setBreakfast(room.getBreakfast() != null ? room.getBreakfast() :
                readByRoomNumber(roomNumber).getBreakfast());
        roomInDb.setCost(room.getCost() != 0 ? room.getCost() :
                readByRoomNumber(roomNumber).getCost());
        roomInDb.setComment(room.getComment() != "" ? room.getComment() :
                readByRoomNumber(roomNumber).getComment());
        roomInDb.setNumberOfBeds(room.getNumberOfBeds() != 0 ? room.getNumberOfBeds() :
                readByRoomNumber(roomNumber).getNumberOfBeds());
        roomInDb.setFree(room.getFree() != null ? room.getFree() :
                readByRoomNumber(roomNumber).getFree());
        roomInDb.setRoomNumber(room.getRoomNumber() != 0 ? room.getRoomNumber() :
                readByRoomNumber(roomNumber).getRoomNumber());
        return save(roomInDb);
    }

    @Override
    public void detach(Room room) {
        entityManager.detach(room);
    }
}