package com.example.projects.AirBnbApp.Project.service;


import com.example.projects.AirBnbApp.Project.dto.HotelDto;
import com.example.projects.AirBnbApp.Project.entity.Hotel;
import com.example.projects.AirBnbApp.Project.exception.ResourceNotFoundException;
import com.example.projects.AirBnbApp.Project.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class HotelServiceImpl implements HotelService{


    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;


    @Override
    public HotelDto createNewHotel(HotelDto hotelDto) {
        log.info("Creating a new hotel with name:{}", hotelDto.getName());

        Hotel hotel = modelMapper.map(hotelDto, Hotel.class);
        hotel.setActive(false);
        hotel =hotelRepository.save(hotel);

        log.info("Created a new hotel withid:{}", hotelDto.getId());
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto getHotelById(Long id) {

        log.info("Getting a new hotel with name:{}", id);

        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with the Id:"+ id));
        return modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long id, HotelDto hotelDto) {
        log.info("Updating a new hotel with name:{}", id);

        Hotel hotel = hotelRepository
                .findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with the Id:"+ id));
                modelMapper.map(hotelDto, hotel);
                hotel.setId(id);
                hotel=hotelRepository.save(hotel);
                return  modelMapper.map(hotel, HotelDto.class);

    }

    @Override
    public Void deleteHotelById(Long id) {
        boolean exists = hotelRepository.existsById(id);
        if(!exists) throw new ResourceNotFoundException("Hotel not found with the Id:"+ id);
        hotelRepository.deleteById(id);
        return null;
    }

    @Override
    public Void activeHotel(Long hotelId) {
        log.info("Activating the hotel with id:{}", hotelId);
        Hotel hotel = hotelRepository
                .findById(hotelId)
                .orElseThrow(()->new ResourceNotFoundException("Hotel not found with the Id:"+ hotelId));

        hotel.setActive(true);
        return null;
    }
}
