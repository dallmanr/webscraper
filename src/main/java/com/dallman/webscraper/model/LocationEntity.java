package com.dallman.webscraper.model;

import javax.persistence.*;

public class LocationEntity extends BaseEntity {

    @Id
    @Column(name = "id")
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Integer id;

    @Column(name = "location_address")
    private String locationAddress;

    @Column(name = "location_type")
    private String locationType;

    @Column(name = "location_events")
    private int locationEvents;

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public int getLocationEvents() {
        return locationEvents;
    }

    public void setLocationEvents(int locationEvents) {
        this.locationEvents = locationEvents;
    }

    @Override
    public String toString() {
        return "LocationEntity{" +
                "locationAddress='" + locationAddress + '\'' +
                ", locationType='" + locationType + '\'' +
                '}';
    }
}
