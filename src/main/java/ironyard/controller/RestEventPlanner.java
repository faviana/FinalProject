package ironyard.controller;

import ironyard.data.EventPlanner;
import ironyard.repositories.EventPlannerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by favianalopez on 11/29/16.
 */
@RestController
@RequestMapping(path = "/rest/planner")
public class RestEventPlanner {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EventPlannerRepository eventPlannerRepository;

    /**
     * create an event planner
     * @param eventPlanner  object being created
     * @return return event planner found by id
     */
    @RequestMapping(value = "a-save", method = RequestMethod.POST)
    public EventPlanner create(@RequestBody EventPlanner eventPlanner) {
        log.debug("Begin save:" + eventPlanner);
        eventPlannerRepository.save(eventPlanner);
        EventPlanner eventPlannerFound = eventPlannerRepository.findOne(eventPlanner.getId());
        log.debug("End save:" + eventPlanner);
        return eventPlannerFound;
    }

    /**
     * select event planner and return it
     * @param id id of event planner being selected
     * @return return event planner found by id
     */
    @RequestMapping(value ="e-get/{id}", method = RequestMethod.POST)
    public EventPlanner select(@PathVariable Long id){
        log.debug("Begin select:" +id);
        EventPlanner eventPlannerFound = eventPlannerRepository.findOne(id);
        log.debug("End select:" +eventPlannerFound);
        return eventPlannerFound;
    }

    /**
     * update event planner
     * @param eventPlanner object being updated
     * @return return event planner found by id
     */
    @RequestMapping(value ="c-update", method = RequestMethod.PUT)
    public EventPlanner update (@RequestBody EventPlanner eventPlanner){
        log.debug("Begin update:" + eventPlanner);
        eventPlannerRepository.save(eventPlanner);
        EventPlanner eventPlannerFound = eventPlannerRepository.findOne(eventPlanner.getId());
        log.debug("End update:" + eventPlanner);
        return eventPlannerFound;
    }

    /**
     * list all the event planners that have been created
     * @return return list found
     */
    @RequestMapping(value="b-list", method = RequestMethod.GET)
    public Iterable<EventPlanner> listAll(){
        Iterable<EventPlanner> EventPlannerFound =  eventPlannerRepository.findAll();
        log.debug(String.format("End listAll: %s", EventPlannerFound));

        return EventPlannerFound;
    }

    /**
     * delete event planner
     * @param id id of event planner to be deleted
     * @return event planner found by id
     */
    @RequestMapping(value ="d-delete", method = RequestMethod.DELETE)
    public EventPlanner delete (@PathVariable Long id){
        log.debug("Beging delete:%s" +id);
        EventPlanner eventPlannerFound = eventPlannerRepository.findOne(id);
        log.debug("End delete:%s" + id);
        return eventPlannerFound;
    }

    /**
     *Handle errors from this controller
     * @param exception exception found
     * @return error message
     */
//    @ExceptionHandler(value = Throwable.class)
//    public String nfeHandler(Throwable exception) {
//        log.error("Error on Event Planner", exception);
//        return "There was an error :/";
//    }
}
