package ironyard.controller;

import ironyard.data.NewEvent;
import ironyard.repositories.EventPlannerRepository;
import ironyard.repositories.NewEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by favianalopez on 11/8/16.
 */
@Controller
@RequestMapping(path="/event")
public class ExistingEventsController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NewEventRepository newEventRepository;

    @Autowired
    private EventPlannerRepository eventPlannerRepository;

    @RequestMapping(value = "/ListAll", method = RequestMethod.GET)
    public String listOfEvents(Model model) {
        String destination = "/list_all_events";
        Iterable<NewEvent> events = newEventRepository.findAll();
        model.addAttribute("events", events);
        return destination;
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteEvent(@RequestParam("id") Long id, HttpServletRequest request) {

        NewEvent event = (NewEvent) request.getSession().getAttribute("event");
        NewEvent findEvent = newEventRepository.findOne(event.getId());

        if(findEvent.getId()==id){
            newEventRepository.delete(findEvent.getId());
        }

        return "redirect:/event/ListAll";

    }
}

