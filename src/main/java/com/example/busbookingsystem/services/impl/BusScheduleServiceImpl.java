package com.example.busbookingsystem.services.impl;

import com.example.busbookingsystem.entities.BusRoute;
import com.example.busbookingsystem.entities.BusSchedule;
import com.example.busbookingsystem.models.ReservationApiException;
import com.example.busbookingsystem.repos.BusRouteRepository;
import com.example.busbookingsystem.repos.BusScheduleRepository;
import com.example.busbookingsystem.services.BusScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusScheduleServiceImpl implements BusScheduleService {
    @Autowired //Automatically injected into this implementation class
    private BusScheduleRepository busScheduleRepository;

    @Autowired
    private BusRouteRepository busRouteRepository;


    @Override
    public BusSchedule addSchedule(BusSchedule busSchedule) throws ReservationApiException{
        final boolean exists = busScheduleRepository.existsByBusAndBusRouteAndDepartureTime(
                busSchedule.getBus(),
                busSchedule.getBusRoute(),
                busSchedule.getDepartureTime());

        if(exists){
            throw new ReservationApiException(HttpStatus.CONFLICT, "Duplicate Schedule");
        }
        return busScheduleRepository.save(busSchedule);
    }

    @Override
    public List<BusSchedule> getAllBusSchedules() {
        return busScheduleRepository.findAll();
    }

    @Override
    public List<BusSchedule> getSchedulesByRoute(String routeName) {
        final BusRoute busRoute = busRouteRepository.findByRouteName(routeName).orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST, "Not Found"));
        return busScheduleRepository.findByBusRoute(busRoute).orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST, "Not Found"));
    }
}
