package com.example.projects.AirBnbApp.Project.repository;



import com.example.projects.AirBnbApp.Project.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
}
