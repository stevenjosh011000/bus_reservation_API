package com.example.busbookingsystem.repos;

import com.example.busbookingsystem.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {

}
