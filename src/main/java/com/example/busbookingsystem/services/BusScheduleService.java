package com.example.busbookingsystem.services;

import com.example.busbookingsystem.entities.BusSchedule;

import java.util.List;

public interface BusScheduleService {

    BusSchedule addSchedule(BusSchedule busSchedule);
    List<BusSchedule> getAllBusSchedules();
    List<BusSchedule> getSchedulesByRoute(String routeName);
}
