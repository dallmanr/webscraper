package com.dallman.webscraper.model;

import com.dallman.webscraper.events.Event;

import javax.persistence.*;

public class LocationEntity extends BaseEntity {

    //    @OneToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "location_events", nullable = false)
    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "event")
    private Event event;

    @Id
    @Column(name = "id")
    private Integer id;
    @Enumerated(EnumType.STRING)
    @Column(name = "location_type")
    private LocationType locationType;

    @Column(name = "location_address")
    private String locationAddress;

    public LocationType getLocationType() {
        return locationType;
    }

//    @Column(name = "location_events")
//    private int locationEvents;

    public String getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress) {
        this.locationAddress = locationAddress;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public Event getEvent() {
        return event;
    }

//    public int getLocationEvents() {
//        return locationEvents;
//    }
//
//    public void setLocationEvents(int locationEvents) {
//        this.locationEvents = locationEvents;
//    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "LocationEntity{" +
                "locationAddress='" + locationAddress + '\'' +
                ", locationType='" + locationType.toString() + '\'' +
                '}';
    }

    public enum LocationType {
        BAR,
        RESTAURANT,
        CLUB,
        MUSEUM,
        PARK
    }
}
