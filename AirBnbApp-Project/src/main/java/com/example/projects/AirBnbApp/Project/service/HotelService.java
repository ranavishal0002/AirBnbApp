package com.example.projects.AirBnbApp.Project.service;


import com.example.projects.AirBnbApp.Project.dto.HotelDto;


public interface HotelService {

    HotelDto createNewHotel (HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long id, HotelDto hotelDto);

    Void  deleteHotelById (Long id);

    Void activeHotel(Long hotelId);
}
