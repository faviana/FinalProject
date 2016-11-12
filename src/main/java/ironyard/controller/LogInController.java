package ironyard.controller;

import ironyard.data.EventPlanner;
import ironyard.repositories.EventPlannerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "password", required = false) String password,
                        @RequestParam(value = "username", required = false) String username,
                        HttpServletRequest request) {
        log.info("Login attempt by:"+username);
        String destination = "login";
        EventPlanner found = eventPlannerRepository.findEventPlannerByUsernameAndPassword(username, password);
        if(found != null){
            request.getSession().setAttribute("eventPlanner",found);
            destination = "redirect:/introduction.jsp";
            log.info("found eventPlanner:"+found.getId());
        }
        log.info("Login attempt result:"+destination);
        return destination;
    }
}
