package com.dallman.webscraper.Controllers;


import com.dallman.webscraper.services.EventService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/events")
public class EventController {

    private final EventService eventService;
    private final Logger logger = LoggerFactory.getLogger(EventController.class);

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @InitBinder
    public void setAllowFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(value = "/index")
    public String getEvents(Model model) {
        model.addAttribute("events", eventService.getEvents());
        return "events/index";
    }
}
