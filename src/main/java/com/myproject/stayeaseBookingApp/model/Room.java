package com.myproject.stayeaseBookingApp.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roomType;
    private BigDecimal roomPrice;
    private boolean isBooked=false;

    @OneToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<BookedRoom> bookings;


    public  Room(){
        this.bookings=new ArrayList<>();
    }


















}
