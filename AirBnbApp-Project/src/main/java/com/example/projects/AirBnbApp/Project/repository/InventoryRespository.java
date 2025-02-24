package com.example.projects.AirBnbApp.Project.repository;

import com.example.projects.AirBnbApp.Project.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRespository extends JpaRepository<Inventory, Long> {
}
