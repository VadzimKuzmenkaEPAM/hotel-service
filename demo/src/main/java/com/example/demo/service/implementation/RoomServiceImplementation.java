package com.example.demo.service.implementation;

import com.example.demo.exceptions.AppException;
import com.example.demo.exceptions.ErrorCode;
import com.example.demo.model.Room;
import com.example.demo.repository.RoomRepository;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


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
        if (roomRepository.readByRoomNumber(number) == null)
            throw new AppException(ErrorCode.ROOM_NOT_FOUND);
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
    public Optional<Room> updateEntityField(Room room, int roomNumber) {
        return Optional.empty();
    }

    @Override
    public Room update(Room room, int id) {
        return roomRepository.save(room);
    }

/*    public Optional<Room> updateEntityField(Room room, int roomNumber) {
        Optional<Room> roomInDb = roomRepository.readByRoomNumber(roomNumber);
        detach(roomInDb);
        roomInDb.get().setId(room.getId() != null ? room.getId() :
                readByRoomNumber(roomNumber).get().getId());
        roomInDb.get().setWifi(room.getWifi() != null ? room.getWifi() :
                readByRoomNumber(roomNumber).get().getWifi());
        roomInDb.get().setFreeParking(room.getFreeParking() != null ? room.getFreeParking() :
                readByRoomNumber(roomNumber).get().getFreeParking());
        roomInDb.get().setConditioner(room.getConditioner() != null ? room.getConditioner() :
                readByRoomNumber(roomNumber).get().getConditioner());
        roomInDb.get().setFridge(room.getFridge() != null ? room.getFridge() :
                readByRoomNumber(roomNumber).get().getFridge());
        roomInDb.get().setNoSmokingRoom(room.getNoSmokingRoom() != null ? room.getNoSmokingRoom() :
                readByRoomNumber(roomNumber).get().getNoSmokingRoom());
        roomInDb.get().setBreakfast(room.getBreakfast() != null ? room.getBreakfast() :
                readByRoomNumber(roomNumber).get().getBreakfast());
        roomInDb.get().setCost(room.getCost() != 0 ? room.getCost() :
                readByRoomNumber(roomNumber).get().getCost());
        roomInDb.get().setComment(room.getComment() != "" ? room.getComment() :
                readByRoomNumber(roomNumber).get().getComment());
        roomInDb.get().setNumberOfBeds(room.getNumberOfBeds() != 0 ? room.getNumberOfBeds() :
                readByRoomNumber(roomNumber).get().getNumberOfBeds());
        roomInDb.get().setFree(room.getFree() != null ? room.getFree() :
                readByRoomNumber(roomNumber).get().getFree());
        roomInDb.get().setRoomNumber(room.getRoomNumber() != 0 ? room.getRoomNumber() :
                readByRoomNumber(roomNumber).get().getRoomNumber());
        return save(roomInDb);
    }*/

    @Override
    public void detach(Optional <Room> room) {
        entityManager.detach(room);
    }
}