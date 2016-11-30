package ironyard.controller;

import ironyard.data.EventPlanner;
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

    /**
     * list all created events
     * @param request extends the ServletRequest interface provides request information for HTTP servlets
     * @param model sets object model on the jsp page
     * @return return destination: list_all_events.jsp
     */
    @RequestMapping(value = "/ListAll", method = RequestMethod.GET)
    public String listOfEvents(HttpServletRequest request, Model model) {

        String destination = "/list_all_events";

        EventPlanner eventPlanner = (EventPlanner) request.getSession().getAttribute("eventPlanner");
        EventPlanner retrieveEventPlanner = eventPlannerRepository.findOne(eventPlanner.getId());

        Iterable<NewEvent> events = retrieveEventPlanner.getEvents();

        model.addAttribute("events", events);

        return destination;
    }

    /**
     * delete event
     * @param id retrieve event id to be deleted
     * @param request extends the ServletRequest interface provides request information for HTTP servlets
     * @return return destionation: controller ListAll
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteEvent(@RequestParam("id") Long id, HttpServletRequest request) {

        String destination = "redirect:/event/ListAll";

        EventPlanner eventPlanner = (EventPlanner) request.getSession().getAttribute("eventPlanner");
        EventPlanner retrieveEventPlanner = eventPlannerRepository.findOne(eventPlanner.getId());
        NewEvent foundEvent = newEventRepository.findOne(id);

        long foundEventId = foundEvent.getId();

        NewEvent eventToBeDeleted = null;
        for(NewEvent tmp: retrieveEventPlanner.getEvents()){
            if(tmp.getId() == foundEventId){
                eventToBeDeleted = tmp;
            }
        }
        retrieveEventPlanner.getEvents().remove(eventToBeDeleted);
        eventPlannerRepository.save(retrieveEventPlanner);
        newEventRepository.delete(foundEventId);
        return destination;

    }

    /**
     * selec event to be updated
     * @param id retrieve id of event to be updated
     * @param model sets object model on the jsp page
     * @return return destination: select,jsp
     */
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    public String selectEvent(@RequestParam("id") Long id, Model model) {

        String destination = "/select";
        NewEvent foundEvent = newEventRepository.findOne(id);
        model.addAttribute("select", foundEvent);

        return destination;
    }
}



