package com.dallman.webscraper.location;


import com.dallman.webscraper.events.Event;
import com.dallman.webscraper.model.LocationEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "location")
public class Location extends LocationEntity implements Serializable {


    private Integer id;

    private String locationName;

    private String locationAddress;

    private String locationDetails;

    private LocationType location;

    private Event event;

    public Location() {
    }

    public Location(Integer id, String locationName, String locationAddress, String locationDetails, LocationType location, Event event) {
        this.id = id;
        this.locationName = locationName;
        this.locationAddress = locationAddress;
        this.locationDetails = locationDetails;
        this.location = location;
        this.event = event;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @Override
    public String getLocationAddress() {
        return locationAddress;
    }

    @Override
    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationDetails() {
        return locationDetails;
    }

    public void setLocationDetails(String locationDetails) {
        this.locationDetails = locationDetails;
    }

    public LocationType getLocation() {
        return location;
    }

    public void setLocation(LocationType location) {
        this.location = location;
    }

    @Override
    public Event getEvent() {
        return event;
    }

    @Override
    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationName='" + locationName + '\'' +
                ", locationAddress='" + locationAddress + '\'' +
                ", location=" + location +
                '}';
    }
}
