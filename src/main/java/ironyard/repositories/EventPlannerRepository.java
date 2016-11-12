package ironyard.repositories;

import ironyard.data.EventPlanner;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by favianalopez on 11/9/16.
 */
public interface EventPlannerRepository extends PagingAndSortingRepository<EventPlanner,Long> {

    EventPlanner findEventPlannerByUsernameAndPassword (String username, String password);
}

