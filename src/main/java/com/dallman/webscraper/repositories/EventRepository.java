package com.dallman.webscraper.repositories;


import com.dallman.webscraper.events.Event;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface EventRepository extends CrudRepository<Event, Integer> {

    @Query(value = "SELECT events.event_name, events.event_date_time, events.event_location, events.event_type, events.events_details FROM events", nativeQuery = true)
    @Transactional(readOnly = true)
    Collection<Event> findAll();

    @Query(value = "SELECT * FROM events where evemts.id =:id", nativeQuery = true)
    @Transactional(readOnly = true)
    Optional<Event> findById(@Param("id") Integer id);

}

