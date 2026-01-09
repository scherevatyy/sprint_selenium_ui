package org.example.model;

import org.example.enums.RentalPeriod;
import org.example.enums.ScooterColor;

import java.time.LocalDate;
import java.util.List;

public class OrderDTO {

    private final String firstName;
    private final String lastName;
    private final String address;
    private final String metroStation;
    private final String phone;
    private final LocalDate date;
    private final RentalPeriod rentalPeriod;
    private final List<ScooterColor> colors;
    private final String comment;

    public OrderDTO(
            String firstName,
            String lastName,
            String address,
            String metroStation,
            String phone,
            LocalDate date,
            RentalPeriod rentalPeriod,
            List<ScooterColor> colors,
            String comment
    ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.date = date;
        this.rentalPeriod = rentalPeriod;
        this.colors = colors;
        this.comment = comment;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getMetroStation() {
        return metroStation;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getDate() {
        return date;
    }

    public RentalPeriod getRentalPeriod() {
        return rentalPeriod;
    }

    public List<ScooterColor> getColors() {
        return colors;
    }

    public String getComment() {
        return comment;
    }
}