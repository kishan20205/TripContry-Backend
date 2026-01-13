package com.tripContry.TripContryManagement.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Setter
@Getter
@Embeddable
public class TripMember {
    private int id;
    private String name;

    public TripMember() {}

}
