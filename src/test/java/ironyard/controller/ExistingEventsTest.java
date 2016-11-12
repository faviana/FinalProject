package ironyard.controller;

import ironyard.data.EventPlanner;
import ironyard.data.NewEvent;
import ironyard.repositories.EventPlannerRepository;
import ironyard.repositories.NewEventRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by favianalopez on 11/11/16.
 */
public class ExistingEventsTest {


    @Autowired
    private NewEventRepository newEventRepository;

    @Autowired
    private EventPlannerRepository eventPlannerRepository;


    @Test
    public void listOfEvents() throws Exception {

    }

    @Test
    public void deleteEvent() throws Exception {

        //create a tested new event
        NewEvent testedEvent = newEventRepository.save(new NewEvent("Bday", "1000",10,"August 12","10:00 pm","Favi's House"));
        //create a tested new event planner
        EventPlanner testedPlanner = eventPlannerRepository.save(new EventPlanner("event","event","event"));
        //add tested event to tested planner
        testedPlanner.getEvents().add(testedEvent);
        //save tested event planner with tested event in repo
        eventPlannerRepository.save(testedPlanner);
        //find event planner where tested event we want to delete
        EventPlanner findTestedPlanner = eventPlannerRepository.findOne(testedPlanner.getId());
        //find tested event by id
        long testedEventId = testedEvent.getId();
        //delete tested event
        newEventRepository.delete(testedEventId);


    }

}