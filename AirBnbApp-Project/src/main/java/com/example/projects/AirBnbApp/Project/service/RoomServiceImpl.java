package com.example.projects.AirBnbApp.Project.service;

import com.example.projects.AirBnbApp.Project.dto.RoomDto;
import com.example.projects.AirBnbApp.Project.entity.Hotel;
import com.example.projects.AirBnbApp.Project.entity.Room;
import com.example.projects.AirBnbApp.Project.exception.ResourceNotFoundException;
import com.example.projects.AirBnbApp.Project.repository.HotelRepository;
import com.example.projects.AirBnbApp.Project.repository.RoomRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServiceImpl implements RoomService{

    private final RoomRepository roomRepository;
    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public RoomDto createNewRoom(Long hotelId, RoomDto roomDto) {

        log.info("Creating a new Room in Hotel with Id: ", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with the Id:"+ hotelId));
        Room room = modelMapper.map(roomDto, Room.class);
        room.setHotel(hotel);
        room = roomRepository.save(room);
        return modelMapper.map(room, RoomDto.class);
    }

    
    @Override
    public List<RoomDto> getAllRoomsInHotel(Long hotelId) {
        log.info("Getting all Room in Hotel with Id: ", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with the Id:"+ hotelId));
        return hotel.getRooms()
                .stream()
                .map((element) -> modelMapper.map(element, RoomDto.class)).collect(Collectors.toList());
    }

    @Override
    public RoomDto getRoomById(Long roomId) {
        log.info("Getting the Room in Hotel with Id: ", roomId);
        Room room = roomRepository
                .findById(roomId)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with the Id:"+ roomId));
        return modelMapper.map(room, RoomDto.class);

    }

    @Override
    public void deleteRoomById(Long roomId) {

        log.info("Creating a new Room in Hotel with Id: ", roomId);
        boolean exists = roomRepository.existsById(roomId);
        if(!exists){
            throw new ResourceNotFoundException("Room not found with Id:"+ roomId);
        }
        roomRepository.deleteById(roomId);
    }
}
