package com.example.projects.AirBnbApp.Project.service;

import com.example.projects.AirBnbApp.Project.dto.RoomDto;

import java.util.List;

public interface RoomService {

RoomDto createNewRoom(Long hotelId, RoomDto roomDto);

List<RoomDto> getAllRoomsInHotel(Long hotelId);

RoomDto getRoomById(Long roomId);

void deleteRoomById(Long roomId);
}
