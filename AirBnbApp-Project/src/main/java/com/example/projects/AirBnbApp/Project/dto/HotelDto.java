package com.example.projects.AirBnbApp.Project.dto;


import com.example.projects.AirBnbApp.Project.entity.HotelContactInfo;
import lombok.Data;



@Data
public class HotelDto {

    private Long id;
    private String name;
    private String city;
    private String[] photos;
    private String[] amenities;
    private HotelContactInfo contactInfo;
    private Boolean active;

}
