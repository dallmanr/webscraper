package com.dallman.webscraper.services;

import com.dallman.webscraper.commands.EventCommand;
import com.dallman.webscraper.events.Event;

import java.util.Set;

public interface EventService {

    Set<Event> getEvents();

    Event findById(Integer i);

    Event save(Event site);

    EventCommand saveEventCommand(EventCommand eventCommand);
}
