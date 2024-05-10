package com.myproject.stayeaseBookingApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roomType;
    @Lob
    private Blob photos;
    private BigDecimal roomPrice;
    private boolean isBooked=false;

    @OneToMany( mappedBy = "room",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;


    public  Room(){
        this.bookings=new ArrayList<>();
    }

    public void addBookinRoom(BookedRoom bookedRoom){
        if(bookings==null){
          bookings=new ArrayList<>();

        }
        bookings.add(bookedRoom);
        bookedRoom.setRoom(this);
        isBooked=true;
        String bookingCode=new Random().nextInt(100)+"";
        bookedRoom.setBookingConfirmationCode(bookingCode);


    }


















}
