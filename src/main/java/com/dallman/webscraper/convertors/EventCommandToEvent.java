package com.dallman.webscraper.convertors;

import com.dallman.webscraper.commands.EventCommand;
import com.dallman.webscraper.events.Event;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EventCommandToEvent implements Converter<EventCommand, Event> {

    public EventCommandToEvent() {
    }

    @Synchronized
    @Nullable
    @Override
    public Event convert(EventCommand source) {
        if (source == null) {
            return null;
        }

        final Event event = new Event();
        event.setEventName(source.getEventName());
        event.setEventDateTime(source.getEventDateTime());
        event.setEventLocation(source.getEventLocation());
        event.setEventType(source.getEventType());
        event.setEventDetails(source.getEventDetails());

        return event;
    }
}
