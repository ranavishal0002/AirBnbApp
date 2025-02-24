package com.example.projects.AirBnbApp.Project.repository;


import com.example.projects.AirBnbApp.Project.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
