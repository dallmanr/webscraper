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

    @Query(value = "SELECT events.id, events.event_name, events.event_date_time, location.location_name, events.event_type, events.event_details FROM events LEFT JOIN location ON events.event_location = location.id", nativeQuery = true)
    @Transactional(readOnly = true)
    Collection<Event> findAll();

    @Query(value = "SELECT * FROM parser.events where parser.events.id =:id", nativeQuery = true)
    @Transactional(readOnly = true)
    Optional<Event> findById(@Param("id") Integer id);

}

