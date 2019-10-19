package com.dallman.webscraper.events;

import com.dallman.webscraper.location.Location;
import com.dallman.webscraper.model.EventEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "events")
public class Event extends EventEntity implements Serializable {

    private Integer id;

    private String eventName;

    private String eventDateTime;

    private Location location;

    private EventType eventType;

    private String eventDetails;

    public Event() {
    }

    public Event(Integer id, String eventName, String eventDateTime, Location location, EventType eventType, String eventDetails) {
        this.id = id;
        this.eventName = eventName;
        this.eventDateTime = eventDateTime;
        this.location = location;
        this.eventType = eventType;
        this.eventDetails = eventDetails;
    }

//    @Override
//    public Integer getId() {
//        return id;
//    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getEventName() {
        return eventName;
    }

    @Override
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    @Override
    public String getEventDateTime() {
        return eventDateTime;
    }

    @Override
    public void setEventDateTime(String eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public EventType getEventType() {
        return eventType;
    }

    @Override
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String getEventDetails() {
        return this.eventDetails;
    }

    @Override
    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", dateFormat=" + eventDateTime +
                '}';
    }
}
