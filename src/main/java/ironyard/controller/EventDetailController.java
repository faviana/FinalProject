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
 * Created by favianalopez on 11/29/16.
 */

@Controller
@RequestMapping(path="/event")
public class EventDetailController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private NewEventRepository newEventRepository;

    @Autowired
    private EventPlannerRepository eventPlannerRepository;

    /**
     * retrieve detail options by id
     * @param id id of detail option to be retrieved
     * @param model sets objects model on the jsp page
     * @return returns destination: eventDetail.jsp
     */
    @RequestMapping(value = "/selectOption", method = RequestMethod.GET)
    public String selectEventDetail(@RequestParam("id") Long id, Model model) {

        String destination = "/eventDetail";
        NewEvent foundEventDetail = newEventRepository.findOne(id);
        model.addAttribute("detail", foundEventDetail);

        return destination;
    }

    /**
     * saves the event details in the event repository
     * @param id id of the event the detail belongs to
     * @param food object being created and saved in repository
     * @param drinks object being created and saved in repository
     * @param desserts object being created and saved in repository
     * @param decorations object being created and saved in repository
     * @param request extends the ServletRequest interface provides request information for HTTP servlets
     * @return
     */
    @RequestMapping(value ="/detailOption", method = RequestMethod.POST)
    public String createEventDetail (@RequestParam("id") Long id,
                              @RequestParam(value = "food", required = false) String food,
                              @RequestParam(value = "drinks", required = false) String drinks,
                              @RequestParam(value = "desserts", required = false) String desserts,
                              @RequestParam(value = "decorations", required = false) String decorations,
                              HttpServletRequest request){

        String destination = "redirect:/event/selectOption?id="+id;

        EventPlanner eventPlanner = (EventPlanner) request.getSession().getAttribute("eventPlanner");
        EventPlanner retrieveEventPlanner = eventPlannerRepository.findOne(eventPlanner.getId());

        NewEvent eventDetail = newEventRepository.findOne(id);

        eventDetail.setFood(food);
        eventDetail.setDrinks(drinks);
        eventDetail.setDesserts(desserts);
        eventDetail.setDecorations(decorations);

        newEventRepository.save(eventDetail);
        retrieveEventPlanner.getEvents().add(eventDetail);
        eventPlannerRepository.save(retrieveEventPlanner);

        return destination;
    }
}
