package com.dallman.webscraper.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class EventEntity extends BaseEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "event_name")
    private String eventName;

    @Column(name = "event_date_time")
    private String eventDateTime;


    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "id")
    private LocationEntity locationEntity;

    private int locationId;

    @Column(name = "event_type")
    private String eventType;

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

    public LocationEntity getLocationEntity() {
        return locationEntity;
    }

    public int getLocationId() {
        return locationEntity.getId();
    }

    public void setLocationEntity(LocationEntity locationEntity) {
        this.locationEntity = locationEntity;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }


    @Override
    public String toString() {
        return "EventEntity{" +
                "dateFormat=" + eventDateTime +
                ", eventLocation='" + locationEntity + '\'' +
                ", eventDetails='" + eventDetails + '\'' +
                '}';
    }
}
