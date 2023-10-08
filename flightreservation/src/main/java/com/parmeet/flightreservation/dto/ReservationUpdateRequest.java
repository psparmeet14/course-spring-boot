package com.parmeet.flightreservation.dto;

import java.util.StringJoiner;

public class ReservationUpdateRequest {
    private Long id;
    private Boolean checkedIn;
    private Integer numberOfBags;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public String toString() {
        return new StringJoiner(", ", ReservationUpdateRequest.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("checkedIn=" + checkedIn)
                .add("numberOfBags=" + numberOfBags)
                .toString();
    }
}
