package ironyard.controller;

import ironyard.data.NewEvent;
import ironyard.repositories.NewEventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by favianalopez on 11/29/16.
 */
@RestController
@RequestMapping(path = "/rest/event")
public class RestNewEvent {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NewEventRepository newEventRepository;

    /**
     * create new event
     * @param newEvent object being created
     * @return return new event found by id
     */
    @RequestMapping(value = "a-save", method = RequestMethod.POST)
    public NewEvent create(@RequestBody NewEvent newEvent) {
        log.debug("Begin save:" + newEvent);
        newEventRepository.save(newEvent);
        NewEvent newEventFound = newEventRepository.findOne(newEvent.getId());
        log.debug("End save:" + newEvent);
        return newEventFound;
    }

    /**
     * select event and return it
     * @param id id of event being selected
     * @return return event found by id
     */
    @RequestMapping(value = "e-get/{id}", method = RequestMethod.GET)
    public NewEvent select(@PathVariable Long id) {
        log.debug("Begin select:" + id);
        NewEvent newEventFound = newEventRepository.findOne(id);
        log.debug("End select:" + newEventFound);
        return newEventFound;

    }

    /**
     * update event
     * @param newEvent object being updated
     * @return return event found by id
     */

    @RequestMapping(value = "c-update", method = RequestMethod.PUT)
    public NewEvent update(@RequestBody NewEvent newEvent) {
        log.debug("Begin update:" + newEvent);
        newEventRepository.save(newEvent);
        NewEvent found = newEventRepository.findOne(newEvent.getId());
        log.debug("End update:" + found);
        return found;
    }

    /**
     * list all the events that have been created
     * @return return list found
     */

    @RequestMapping(value = "b-list", method = RequestMethod.GET)
    public Iterable<NewEvent> listAll() {

        Iterable<NewEvent> newEventFound =  newEventRepository.findAll();
        log.debug(String.format("End listAll: %s", newEventFound));

        return newEventFound;
    }

    /**
     * delete event
     * @param id id of event to be deleted
     * @return return event found by id
     */

    @RequestMapping(value = "d-delete/{id}", method = RequestMethod.DELETE)
    public NewEvent delete(@PathVariable Long id) {
        log.debug(String.format("Begin delete: %s", id));
        NewEvent newEventDeleted = newEventRepository.findOne(id);
        newEventRepository.delete(id);
        log.debug(String.format("End delete: %s", newEventDeleted));
        return newEventDeleted;
    }

    /**
     *Handle errors from this controller
     * @param exception exception found
     * @return error message
     */

    @ExceptionHandler(value = Throwable.class)
    public String nfeHandler(Throwable exception) {
        log.error("Error on New Event", exception);
        return "There was an error :/";
    }

}
