package com.parmeet.flightreservation.controllers;

import com.parmeet.flightreservation.entities.Flight;
import com.parmeet.flightreservation.repos.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    @Autowired
    private FlightRepository flightRepository;

    @RequestMapping(value = "/findFlights", method = RequestMethod.POST)
    public String findFlights(
            @RequestParam("from") String from,
            @RequestParam("to") String to,
            @RequestParam("departureDate") @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate,
            ModelMap modelMap
    ) {
        LOGGER.info("Inside findFlights() from: " + from + " to: " + to + " departure date: " + departureDate);
        List<Flight> flights = flightRepository.findFlights(from, to, departureDate);
        modelMap.addAttribute("flights", flights);
        LOGGER.info("Flights found are : " + flights);
        return "displayFlights";
    }

    @RequestMapping("/admin/showAddFlight")
    public String showAddFlight() {
        return "addFlight";
    }
}
