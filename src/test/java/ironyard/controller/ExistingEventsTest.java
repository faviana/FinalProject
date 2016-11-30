package ironyard.controller;

import ironyard.data.EventPlanner;
import ironyard.data.NewEvent;
import ironyard.repositories.EventPlannerRepository;
import ironyard.repositories.NewEventRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by favianalopez on 11/11/16.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ExistingEventsTest {


    @Autowired
    private NewEventRepository newEventRepository;

    @Autowired
    private EventPlannerRepository eventPlannerRepository;

    /**
     * before each test clear from database existing event planners
     */

    @Before
    public void clearEventPlanner(){
        Iterator<EventPlanner> eventPlanner =  eventPlannerRepository.findAll().iterator();
        while(eventPlanner.hasNext()){
            eventPlannerRepository.delete(eventPlanner.next().getId());
        }
    }

    /**
     * find event planner by username and password
     * @throws Exception
     */

    @Test
    public void testFindEventPlannerByUsernameAndPassword() throws Exception{

        //create tested event planner
        EventPlanner testEventPlanner = new EventPlanner("event","event","event");
        //save tested event planner in repository
        eventPlannerRepository.save(testEventPlanner);
        //find tested event planner by username and password
        EventPlanner findTestEventPlanner = eventPlannerRepository.findEventPlannerByUsernameAndPassword("event","event");
        //assert event planner is found
        Assert.assertNotNull(findTestEventPlanner);
    }

    /**
     * list all events created
     * @throws Exception
     */

    @Test
    public void testListOfEvents() throws Exception {

        //create tested event planner
        EventPlanner testedEventPlanner = eventPlannerRepository.save(new EventPlanner("event","event", "event"));
        //create tested new event
        NewEvent testedEvent = newEventRepository.save(new NewEvent("Bday", "1000",10,"August 12","10:00 pm","Favi's House","Steak","Sangria","Cupcake","Balloons"));
        //add tested event to tested event planner
        testedEventPlanner.setEvents(new HashSet<>());
        testedEventPlanner.getEvents().add(testedEvent);
        //save tested event in event planner repo
        eventPlannerRepository.save(testedEventPlanner);
        // find all created tested events
        newEventRepository.findAll();
        //assert list of tested events
        Assert.assertNotNull(testedEvent);

    }

    /**
     * create an event
     * @throws Exception
     */

    @Test
    public void testCreateEvent() throws Exception{

        //create tested event planner
        EventPlanner testedPlanner = eventPlannerRepository.save(new EventPlanner("event","event","event"));
        //create tested new event
        NewEvent testedEvent = newEventRepository.save(new NewEvent("Bday", "1000",10,"August 12","10:00 pm","Favi's House","Steak","Sangria","Cupcake","Balloons"));
        //add tested event to tested planner
        testedPlanner.setEvents(new HashSet<>());
        testedPlanner.getEvents().add(testedEvent);
        //save tested event in event planner repo
        eventPlannerRepository.save(testedPlanner);
        //find event planner where tested event we want to create
        EventPlanner findTestedPlanner = eventPlannerRepository.findOne(testedPlanner.getId());
        // assert that the object now exists
        Assert.assertNotNull(findTestedPlanner);
    }

    /**
     * update an event
     * @throws Exception
     */

    @Test
    public void testUpdateEvent() throws Exception{

        //create tested event planner
        EventPlanner testedEventPlanner = new EventPlanner("event","event","event");
        // create tested new event
        NewEvent testedEvent = newEventRepository.save(new NewEvent("Bday", "1000",10,"August 12","10:00 pm","Favi's House","Steak","Sangria","Cupcake","Balloons"));
        //fetch event
        testedEventPlanner.setEvents(new HashSet<>());
        //add tested event to tested planner
        testedEventPlanner.getEvents().add(testedEvent);
        //save event in respective event planner
        eventPlannerRepository.save(testedEventPlanner);
        //find event planner by id
        EventPlanner findTestEventPlanner = eventPlannerRepository.findOne(testedEventPlanner.getId());
        //assert event planner iterates through event ids
        Assert.assertNotNull(findTestEventPlanner.getEvents().iterator().next().getId());
        //find matching event id
        long newEventId = findTestEventPlanner.getEvents().iterator().next().getId();
        //assert it's in the repository
        eventPlannerRepository.exists(findTestEventPlanner.getId());
        //find matching event id and update
        Assert.assertNotNull(newEventRepository.findOne(newEventId));
    }

    /**
     * delete an event
     * @throws Exception
     */

    @Test
    public void testDeleteEvent() throws Exception {

        //create tested event planner
        EventPlanner testedPlanner = eventPlannerRepository.save(new EventPlanner("event","event","event"));
        //create tested new event
        NewEvent testedEvent = newEventRepository.save(new NewEvent("Bday", "1000",10,"August 12","10:00 pm","Favi's House","Steak","Sangria","Cupcake","Balloons"));
        //add tested event to tested planner
        testedPlanner.setEvents(new HashSet<>());
        testedPlanner.getEvents().add(testedEvent);
        //save tested event in event planner repo
        eventPlannerRepository.save(testedPlanner);
        //find event planner where tested event we want to delete
        EventPlanner findTestedPlanner = eventPlannerRepository.findOne(testedPlanner.getId());
        // assert that the object now exists
        Assert.assertNotNull(findTestedPlanner);
        //remove from parent
        long testedEventId = testedEvent.getId();
        NewEvent removeMe = null;
        for(NewEvent e:findTestedPlanner.getEvents()){
            if(e.getId() == testedEventId){
                removeMe = e;
            }
        }
        // now remove from collection
        findTestedPlanner.getEvents().remove(removeMe);
        eventPlannerRepository.save(findTestedPlanner);
        //delete tested event
        newEventRepository.delete(testedEventId);
        // assert event is gone
        Assert.assertNull(newEventRepository.findOne(testedEvent.getId()));
        // clean up
        eventPlannerRepository.delete(testedPlanner.getId());
    }


}