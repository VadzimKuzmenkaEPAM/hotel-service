package com.example.demo.repository;

import com.example.demo.model.Room;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
@EnableTransactionManagement
public interface RoomRepository extends CrudRepository<Room, Long> {
    String FIND_BY_ROOM_NUMBER_QUERY = "SELECT id, " +
            "wifi, " +
            "free_parking as freeParking, " +
            "conditioner, " +
            "fridge, " +
            "no_smoking_room as noSmokingRoom, " +
            "breakfast, " +
            "cost, " +
            "comment, " +
            "number_of_beds as numberOfBeds, " +
            "free, " +
            "room_number as roomNumber " +
            "FROM public.rooms_1 WHERE public.rooms_1.room_number = :number";

    String FIND_FREE_ROOM = "SELECT id, " +
            "wifi, " +
            "free_parking as freeParking, " +
            "conditioner, " +
            "fridge, " +
            "no_smoking_room as noSmokingRoom, " +
            "breakfast, " +
            "cost, " +
            "comment, " +
            "number_of_beds as numberOfBeds, " +
            "free, " +
            "room_number as roomNumber " +
            "FROM public.rooms_1 WHERE public.rooms_1.free = :free";

    String CHANGE_ROOM_STATUS_QUERY = "UPDATE public.rooms_1 SET free =:free where room_number =:number";

    @Query(value = FIND_BY_ROOM_NUMBER_QUERY, nativeQuery = true)
    Room readByRoomNumber(int number);

    @Query(value = FIND_FREE_ROOM, nativeQuery = true)
    List<Room> findFreeNumber(boolean free);

    @Modifying
    @Query(value = CHANGE_ROOM_STATUS_QUERY, nativeQuery = true)
    @Transactional
    void takeRoom(@Param("number")int number, @Param("free") boolean free);
}