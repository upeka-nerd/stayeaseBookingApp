package com.myproject.stayeaseBookingApp.controller;

import com.myproject.stayeaseBookingApp.model.Room;
import com.myproject.stayeaseBookingApp.response.RoomResponse;
import com.myproject.stayeaseBookingApp.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:5174/")
@RestController
@RequestMapping("/rooms")
@RequiredArgsConstructor

public class RoomController {


 private final IRoomService iRoomService;

    @PostMapping("/add/new-rooms")
    public ResponseEntity<RoomResponse>addRoom(@RequestParam("photo") MultipartFile photos,
                                               @RequestParam("roomType") String roomType,
                                               @RequestParam("roomPrice") BigDecimal roomPrice) throws SQLException, IOException {
        Room savedRoom= iRoomService.addNewRoom(photos,roomType,roomPrice);

        RoomResponse roomResponse=new RoomResponse(savedRoom.getId()
                ,savedRoom.getRoomType(),savedRoom.getRoomPrice());
        return ResponseEntity.ok(roomResponse);



    }

    @GetMapping("/room/types")
    public List<String> getRoomTypes() {
        return iRoomService.getAllRoomTypes();
    }











}
