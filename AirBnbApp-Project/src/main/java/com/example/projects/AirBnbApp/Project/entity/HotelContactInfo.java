package com.example.projects.AirBnbApp.Project.entity;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class HotelContactInfo {

    private String email;
    private String address;
    private String phoneNumber;
    private String location;

}
