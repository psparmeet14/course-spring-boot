package com.parmeet.flightreservation.controllers;

import com.parmeet.flightreservation.dto.ReservationRequest;
import com.parmeet.flightreservation.entities.Flight;
import com.parmeet.flightreservation.entities.Reservation;
import com.parmeet.flightreservation.repos.FlightRepository;
import com.parmeet.flightreservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {

    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private ReservationService reservationService;

    @RequestMapping("/showCompleteReservation")
    public String showCompleteReservation(@RequestParam("flightId") Long flightId,
                                          ModelMap modelMap) {
        Flight flight = flightRepository.findById(flightId).orElse(null);
        modelMap.addAttribute("flight", flight);
        return "completeReservation";
    }

    @RequestMapping(value = "/completeReservation", method = RequestMethod.POST)
    public String completeReservation(@ModelAttribute("request") ReservationRequest request,
                                      ModelMap modelMap) {
        Reservation reservation = reservationService.bookFlight(request);
        modelMap.addAttribute("msg", "Reservation is confirmed and the Id is " + reservation.getId());
        return "reservationConfirmation";
    }
}
