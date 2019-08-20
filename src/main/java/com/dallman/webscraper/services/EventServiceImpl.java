package com.dallman.webscraper.services;

import com.dallman.webscraper.commands.EventCommand;
import com.dallman.webscraper.convertors.EventCommandToEvent;
import com.dallman.webscraper.convertors.EventToEventCommand;
import com.dallman.webscraper.events.Event;
import com.dallman.webscraper.repositories.EventRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventToEventCommand eventToEventCommand;
    private final EventCommandToEvent eventCommandToEvent;

    public EventServiceImpl(EventRepository eventRepository, EventToEventCommand eventToEventCommand, EventCommandToEvent eventCommandToEvent) {
        this.eventRepository = eventRepository;
        this.eventToEventCommand = eventToEventCommand;
        this.eventCommandToEvent = eventCommandToEvent;
    }


    @Override
    public Set<Event> getEvents() {
        Set<Event> eventSet = new HashSet<>();
        eventRepository.findAll().iterator().forEachRemaining((eventSet::add));
        return eventSet;
    }

    @Override
    public Event findById(Integer i) {
        Optional<Event> eventOptional = eventRepository.findById(i);
        if (!eventOptional.isPresent()) {
            throw new RuntimeException("User not found");
        }
        return eventOptional.get();
    }

    @Override
    public Event save(Event event) {
        Event aEvent = eventRepository.save(event);
        return aEvent;
    }

    @Override
    @Transactional
    public EventCommand saveEventCommand(EventCommand source) {
        Event detachedEvent = eventCommandToEvent.convert(source);

        Event savedEvent = eventRepository.save(detachedEvent);
        return eventToEventCommand.convert(savedEvent);
    }
}
