package com.tallstech.volunteer.controller;

import java.util.List;
import java.util.Map;

import com.tallstech.volunteer.model.Location;
import com.tallstech.volunteer.service.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationController implements LocationApi{

    private LocationService locationService;

    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }

    @Override
    public ResponseEntity<List<Location>> getLocations(Map<String, String> header, String city, String district, String town) throws Exception {
        return ResponseEntity.ok(locationService.getClickableLocations(city,district,town));
    }
}
