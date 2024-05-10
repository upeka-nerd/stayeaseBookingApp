package com.myproject.stayeaseBookingApp.service;

import com.myproject.stayeaseBookingApp.model.Room;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public interface IRoomService {
    Room addNewRoom(MultipartFile photos, String roomType, BigDecimal roomPrice) throws IOException, SQLException;
}
