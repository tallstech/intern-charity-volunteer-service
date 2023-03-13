package com.tallstech.volunteer.service;

import java.util.List;

import com.tallstech.volunteer.model.Location;
import com.tallstech.volunteer.repository.LocationRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class LocationService {

    private LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public List<Location> getClickableLocations(String city, String district, String town, String zipCode) throws Exception {
        List<Location> locations;
        if (ObjectUtils.isEmpty(city) && ObjectUtils.isEmpty(district) && ObjectUtils.isEmpty(town)) {
            locations = getClickableCities();
        } else if (ObjectUtils.isNotEmpty(city) && ObjectUtils.isEmpty(district)) {
            locations = getClickableDistricts(city);
        } else if (ObjectUtils.isNotEmpty(city) && ObjectUtils.isNotEmpty(district)&&ObjectUtils.isEmpty(town)) {
            locations = getClickableTowns(city, district);
        } else if (ObjectUtils.isNotEmpty(city) && ObjectUtils.isNotEmpty(district)&&ObjectUtils.isNotEmpty(town)&&ObjectUtils.isEmpty(zipCode)) {
            locations = getClickableNeighborhoods(city, district, town);
        } else if (ObjectUtils.isNotEmpty(city) && ObjectUtils.isNotEmpty(district)&&ObjectUtils.isNotEmpty(town)&&ObjectUtils.isNotEmpty(zipCode)) {
            locations = getClickableNeighborhoodsWithZipCode(city, district, town, zipCode);
        } else {
            log.error("An exception occurred while fetching locations, city: {}, district: {}, town: {}", city, district, town);
            throw new RuntimeException("An exception occurred while fetching locations, city: " + city + ", district: " + district + ", town: " + town);
        }
        return locations;
    }

    private List<Location> getClickableCities() {
        return locationRepository.fetchCities();
    }

    private List<Location> getClickableDistricts(String city) throws Exception {
        return locationRepository.fetchClickableDistricts(city);
    }

    private List<Location> getClickableTowns(String city, String district) {
        return locationRepository.fetchClickableTowns( city, district);
    }

    private List<Location> getClickableNeighborhoods(String city, String district, String town) {
        return locationRepository.fetchClickableNeighborhoods(city, district, town);
    }

    private List<Location> getClickableNeighborhoodsWithZipCode(String city, String district, String town, String zipCode) {
        return locationRepository.fetchClickableNeighborhoodsWithZıpCode(city, district, town, zipCode);
    }

}
