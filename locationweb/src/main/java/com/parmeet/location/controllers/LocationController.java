package com.parmeet.location.controllers;

import com.parmeet.location.entities.Location;
import com.parmeet.location.repos.LocationRepository;
import com.parmeet.location.service.LocationService;
import com.parmeet.location.util.EmailUtil;
import com.parmeet.location.util.ReportUtil;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private EmailUtil emailUtil;

    @Autowired
    private ReportUtil reportUtil;

    @Autowired
    private ServletContext servletContext;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createLocation";
    }

    @RequestMapping("/saveLoc")
    public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        Location locationSaved = locationService.saveLocation(location);
        String msg = "Location saved with id: " + locationSaved.getId();
        modelMap.addAttribute("msg", msg);
        /*emailUtil.sendEmail("workflow123test@gmail.com", "Location Saved", "Location Saved Successfully" +
                "and about to return a response");*/
        return "createLocation";
    }

    @RequestMapping("/displayLocations")
    public String displayLocations(ModelMap modelMap) {
        List<Location> allLocations = locationService.getAllLocations();
        modelMap.addAttribute("locations", allLocations);
        return "displayLocations";
    }

    @RequestMapping("/deleteLocation")
    public String deleteLocation(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = locationService.getLocationById(id);
        locationService.deleteLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/showUpdate")
    public String showUpdate(@RequestParam("id") int id, ModelMap modelMap) {
        Location location = locationService.getLocationById(id);
        modelMap.addAttribute("location", location);
        return "updateLocation";
    }

    @RequestMapping("/updateLoc")
    public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
        locationService.updateLocation(location);
        List<Location> locations = locationService.getAllLocations();
        modelMap.addAttribute("locations", locations);
        return "displayLocations";
    }

    @RequestMapping("/generateReport")
    public String generateReport() {
        String path = servletContext.getRealPath("/");
        List<Object[]> data = locationRepository.findByTypeAndTypeCount();
        reportUtil.generatePieChart(path, data);
        return "report";
    }
}
