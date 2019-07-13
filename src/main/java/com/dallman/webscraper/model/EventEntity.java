package com.dallman.webscraper.model;

import javax.persistence.Column;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class EventEntity extends BaseEntity {

    @Column(name = "event_date_time")
    private DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    @Column(name = "event_location")
    private String eventLocation;

    @Column(name = "event_details")
    private String eventDetails;

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    @Override
    public String toString() {
        return "EventEntity{" +
                "dateFormat=" + dateFormat +
                ", eventLocation='" + eventLocation + '\'' +
                ", eventDetails='" + eventDetails + '\'' +
                '}';
    }
}
