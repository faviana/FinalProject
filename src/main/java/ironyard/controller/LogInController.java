package ironyard.controller;

import ironyard.data.EventPlanner;
import ironyard.repositories.EventPlannerRepository;
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
 * Created by favianalopez on 11/9/16.
 */
@Controller
@RequestMapping(path="/event")
public class LogInController {

private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EventPlannerRepository eventPlannerRepository;

    /**
     * retrieve an event planner from database by username and password and
     * allow event planner to login into session. if event planner
     * not found create an error message
     * @param password string password required to login into session
     * @param username string username required to login into session
     * @param request Extends the ServletRequest interface, provides request information for HTTP servlets
     * @param model sets object model on the jsp page
     * @return returns destination: introduction.jsp
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "password", required = false) String password,
                        @RequestParam(value = "username", required = false) String username,
                        HttpServletRequest request,
                        Model model) {
        log.info("Login attempt by:"+username);
        String destination = "login";
        EventPlanner found = eventPlannerRepository.findEventPlannerByUsernameAndPassword(username, password);

        //verify event planner login credentials
        if(found != null){
            request.getSession().setAttribute("eventPlanner",found);
            destination = "redirect:/introduction.jsp";
            log.info("found eventPlanner:"+found.getId());

        //if event planner not found send and error message
        }else{
            model.addAttribute("errorMessage", "Invalid Username or Password, please try again!");

        }

        log.info("Login attempt result:"+destination);
        return destination;
    }

    /**
     * create a new event planner
     * verifies password is correct
     * logs-in new event planner into session
     * @param username create a username that is going to be stored in the database and it is going to be used to login
     *                 into session
     * @param displayName create a displayName that is going to be stored in the database and it is going to be displayed
     *                    when in session
     * @param password create a password that is going to be stored in the database and it is going to be used to login
     *                 into session
     * @param password2 Verify password2 matches password, if password don't match error message will be created
     * @param model sets object model on the jsp page
     * @return returns destination: introduction.jsp
     */
    @RequestMapping(value = "/newEventPlanner", method = RequestMethod.POST)
    public String newEventPlanner(@RequestParam("username") String username,
                                  @RequestParam("displayName") String displayName,
                                  @RequestParam("password") String password,
                                  @RequestParam("password2") String password2,
                                  HttpServletRequest request,
                                  Model model) {

        String destination = "redirect:/introduction.jsp";

        // if password doesn't match create and error message
        if(!password.equals(password2)){
            model.addAttribute("error_message", "Passwords do not match, please try again");

            Iterable<EventPlanner> eventPlanner = eventPlannerRepository.findAll();

            model.addAttribute("eventPlanner",eventPlanner);
            destination = "/createNewEventPlanner";
            model.addAttribute("username", username);
            model.addAttribute("displayName", displayName);

        // if password matches create event planner
        }else{
            EventPlanner eventPlanner = new EventPlanner();
            eventPlanner.setUsername(username);
            eventPlanner.setDisplayName(displayName);
            eventPlanner.setPassword(password);
            eventPlannerRepository.save(eventPlanner);
            EventPlanner retrieveEventPlanner = eventPlannerRepository.findOne(eventPlanner.getId());

            request.getSession().setAttribute("eventPlanner",retrieveEventPlanner);
        }

        return destination;
    }

    /**
     * event planner is logged out of session
     * @param request extends the ServletRequest interface provides request information for HTTP servlets
     * @return returns destination: login
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        String destination = "/login";

        EventPlanner foundEventPlanner = (EventPlanner) request.getSession().getAttribute("eventPlanner");

        if(foundEventPlanner != null) {
            log.info("Logging out user with id:" + foundEventPlanner.getId());
        }

        request.getSession().invalidate();
        return destination;
    }
}
