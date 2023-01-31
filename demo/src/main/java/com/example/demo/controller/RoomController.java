package com.example.demo.controller;

import com.example.demo.model.Room;
import com.example.demo.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/{id}")
    ResponseEntity<Room> findById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.readByRoomNumber(id));
    }

    @GetMapping("status/{status}")
    public ResponseEntity<List<Room>> findFreeRoom (@PathVariable Boolean status) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.findFreeNumber(status));
    }

    @PostMapping
    public ResponseEntity<Room> create(@RequestBody Room room) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.save(room));
    }

 /*   @PatchMapping ("/{id}")
    public ResponseEntity<Room> update(@RequestBody Room room,
                                       @PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.updateEntityField(room, id));
    }*/
}