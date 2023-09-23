package com.parmeet.flightreservation.controllers;

import com.parmeet.flightreservation.entities.Flight;
import com.parmeet.flightreservation.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId,
                                          ModelMap modelMap) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }
}
