package com.myproject.stayeaseBookingApp.response;

import com.myproject.stayeaseBookingApp.model.BookedRoom;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponse {



    private long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked;
    private String photos;

    private List<BookedResponse>bookings;


    public RoomResponse(long id, String roomType, BigDecimal roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
    }

    public RoomResponse(long id, String roomType,
                        BigDecimal roomPrice, boolean isBooked,
                        byte[] photoByte, List<BookedResponse> bookings) {
        this.id = id;
        this.roomType = roomType;
        this.roomPrice = roomPrice;
        this.isBooked = isBooked;
        this.photos = photoByte ==null? Base64.encodeBase64String(photoByte):null;
        this.bookings = bookings;
    }
}
