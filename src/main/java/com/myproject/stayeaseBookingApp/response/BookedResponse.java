package com.myproject.stayeaseBookingApp.response;

import com.myproject.stayeaseBookingApp.model.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class BookedResponse {


    private long bookingId;

    private LocalDate checkInDate;

    private LocalDate checkOutDate;

    private String guestFullName;

    private String guestEmail;

    private int numberOfAdults;

    private int numberOfChildrens;

    private int totalNumberOfGuests;

    private String bookingConfirmationCode;
    private Room room;


    public BookedResponse(long bookingId, LocalDate checkInDate,
                          LocalDate checkOutDate, String bookingConfirmationCode) {
        this.bookingId = bookingId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.bookingConfirmationCode = bookingConfirmationCode;
    }












}
