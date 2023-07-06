package com.example.busbookingsystem.controller;

import com.example.busbookingsystem.entities.Bus;
import com.example.busbookingsystem.models.ResponseModel;
import com.example.busbookingsystem.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {
    @Autowired
    private BusService busService;

    @PostMapping("/add")
    public ResponseModel<Bus> addBus(@RequestBody Bus bus){
        final Bus savedBus = busService.addBus(bus);
        return new ResponseModel<>(HttpStatus.OK.value(),"Bus saved",savedBus);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bus>> getAllBus(){
        return ResponseEntity.ok(busService.getAllBus());
    }
}
