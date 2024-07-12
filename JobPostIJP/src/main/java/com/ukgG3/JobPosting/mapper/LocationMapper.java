package com.ukgG3.JobPosting.mapper;

import com.ukgG3.JobPosting.dto.LocationDto;
import com.ukgG3.JobPosting.entity.Location;

public class LocationMapper {

    public static LocationDto mapToLocationDto(Location location, LocationDto locationDto) {

        locationDto.setName(location.getName());
        return locationDto;
    }

    public static Location mapToLocation(LocationDto locationDto, Location location) {

        location.setName(locationDto.getName());
        return location;
    }


}
