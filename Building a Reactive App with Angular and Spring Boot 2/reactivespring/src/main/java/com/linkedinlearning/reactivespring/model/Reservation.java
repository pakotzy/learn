package com.linkedinlearning.reactivespring.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document
public class Reservation {
    @Id
    private String id;

    private Long roomNumber;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate checkIn;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate checkOut;
    private BigDecimal price;

    public Reservation() {
    }

    public Reservation(Long roomNumber, LocalDate checkIn, LocalDate checkOut, BigDecimal price) {
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Reservation [checkIn=" + checkIn + ", checkOut=" + checkOut + ", id=" + id + ", price=" + price
                + ", roomNumber=" + roomNumber + "]";
    }
}
