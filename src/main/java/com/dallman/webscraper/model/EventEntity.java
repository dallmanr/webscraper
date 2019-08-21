package com.dallman.webscraper.model;

import com.dallman.webscraper.location.Location;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class EventEntity extends BaseEntity implements Serializable {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id", nullable = false)
    private Location location;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_date_time")
    private String eventDateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type")
    private EventType eventType;

    public Location getLocation() {
        return location;
    }

    @Column(name = "event_details")
    private String eventDetails;

    public String getEventDateTime() {
        return eventDateTime;
    }

    public void setEventDateTime(String eventDateTime) {
        this.eventDateTime = eventDateTime;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setLocationEntity(Location location) {
        this.location = location;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "dateFormat=" + eventDateTime +
                ", eventLocation='" + location.toString() + '\'' +
                ", eventDetails='" + eventDetails + '\'' +
                '}';
    }


    public enum EventType {
        MUSIC,
        MOVIE,
        DANCE,
        THEATRE,
        COMEDY,
        FAMILY,
    }
}
