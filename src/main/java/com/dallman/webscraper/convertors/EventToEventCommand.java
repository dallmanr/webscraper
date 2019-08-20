package com.dallman.webscraper.convertors;


import com.dallman.webscraper.commands.EventCommand;
import com.dallman.webscraper.events.Event;
import io.micrometer.core.lang.Nullable;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class EventToEventCommand implements Converter<Event, EventCommand> {

    public EventToEventCommand() {
    }

    @Synchronized
    @Nullable
    @Override
    public EventCommand convert(Event source) {
        if (source == null) {
            return null;
        }

        final EventCommand command = new EventCommand();
        command.setId(source.getId());
        command.setEventName(source.getEventName());
        command.setEventDateTime(source.getEventDateTime());
        command.setLocation(source.getLocation());
        command.setEventType(source.getEventType());
        command.setEventDetails(source.getEventDetails());
        return command;
    }
}
