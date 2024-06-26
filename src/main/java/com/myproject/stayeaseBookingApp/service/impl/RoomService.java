package com.myproject.stayeaseBookingApp.service.impl;

import com.myproject.stayeaseBookingApp.model.Room;
import com.myproject.stayeaseBookingApp.repository.RoomRepo;
import com.myproject.stayeaseBookingApp.service.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {


    private final RoomRepo roomRepo;
    @Override
    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws IOException
            , SQLException {

        Room room=new Room();
        room.setRoomType(roomType);
        room.setRoomPrice(roomPrice);
        if(!file.isEmpty()){
            byte []phtobytes= file.getBytes();
            Blob photoBlob=new SerialBlob(phtobytes);
            room.setPhotos(photoBlob);
        }

        return roomRepo.save(room);
    }

    @Override
    public List<String> getAllRoomTypes() {
        return roomRepo.findDistinctRoomTypes();
    }
}
