package com.example.busbookingsystem.services;

import com.example.busbookingsystem.entities.Bus;

import java.util.List;

public interface BusService {
    Bus addBus(Bus bus);
    List<Bus> getAllBus();
}
