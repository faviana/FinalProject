package ironyard.controller;

import ironyard.data.EventPlanner;
import ironyard.data.NewEvent;
import ironyard.repositories.EventPlannerRepository;
import ironyard.repositories.NewEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by favianalopez on 11/7/16.
 */
@Controller
@RequestMapping(path = "/event/")
public class NewEventController {

    @Autowired
    private NewEventRepository newEventRepository;

    @Autowired
    private EventPlannerRepository eventPlannerRepository;

    /**
     * save new event
     * @param nameOfEvent string to be created or updated
     * @param budget string to be created or updted
     * @param numberOfGuests int to be created or updated
     * @param id boolean if id doesn't exist create, if id exists update
     * @param dateOfEvent string to be created or updated
     * @param timeOfEvent string to be created or updted
     * @param location string to be created or update
     * @param request extends the ServletRequest interface provides request information for HTTP servlets
     * @return return direction: controller ListAll
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String createNewEvent(@RequestParam("nameOfEvent") String nameOfEvent,
                                 @RequestParam("budget") String budget,
                                 @RequestParam("numberOfGuests") int numberOfGuests,
                                 @RequestParam(value = "id", required = false) Long id,
                                 @RequestParam("dateOfEvent") String dateOfEvent,
                                 @RequestParam("timeOfEvent") String timeOfEvent,
                                 @RequestParam("location") String location,
                                 HttpServletRequest request) {

        String destination = "redirect:/event/ListAll";

        EventPlanner eventPlanner = (EventPlanner) request.getSession().getAttribute("eventPlanner");
        EventPlanner retrieveEventPlanner = eventPlannerRepository.findOne(eventPlanner.getId());

        NewEvent newEvent = null;

        //create new event
        if(id==null) {

            newEvent = new NewEvent();

        //update event
        }else{
            newEvent = newEventRepository.findOne(id);
        }
        newEvent.setNameOfEvent(nameOfEvent);
        newEvent.setBudget(budget);
        newEvent.setNumberOfGuests(numberOfGuests);
        newEvent.setDateOfEvent(dateOfEvent);
        newEvent.setTimeOfEvent(timeOfEvent);
        newEvent.setLocation(location);
        newEventRepository.save(newEvent);
        retrieveEventPlanner.getEvents().add(newEvent);
        eventPlannerRepository.save(retrieveEventPlanner);

        return destination;
    }

}

