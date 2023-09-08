package com.parmeet.location.service;

import com.parmeet.location.entities.Location;
import com.parmeet.location.repos.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repo;

    @Override
    public Location saveLocation(Location location) {
        return repo.save(location);
    }

    @Override
    public Location updateLocation(Location location) {
        return repo.save(location);
    }

    @Override
    public void deleteLocation(Location location) {
        repo.delete(location);
    }

    @Override
    public Location getLocationById(int id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Location> getAllLocations() {
        return repo.findAll();
    }
}
