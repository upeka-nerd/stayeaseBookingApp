package com.myproject.stayeaseBookingApp.controller;

import com.myproject.stayeaseBookingApp.model.Room;
import com.myproject.stayeaseBookingApp.response.RoomResponse;
import com.myproject.stayeaseBookingApp.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;


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











}
