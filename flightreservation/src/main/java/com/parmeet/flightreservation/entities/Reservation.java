package com.parmeet.flightreservation.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;

import java.util.StringJoiner;

@Entity
public class Reservation extends AbstractEntity {
    private Boolean checkedIn;
    private Integer numberOfBags;
    @OneToOne
    private Passenger passenger;
    @OneToOne
    private Flight flight;

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Integer getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(Integer numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Reservation.class.getSimpleName() + "[", "]")
                .add("checkedIn=" + checkedIn)
                .add("numberOfBags=" + numberOfBags)
                .add("passenger=" + passenger)
                .add("flight=" + flight)
                .toString();
    }
}
