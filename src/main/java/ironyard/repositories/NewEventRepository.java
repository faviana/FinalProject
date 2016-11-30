package ironyard.repositories;

import ironyard.data.NewEvent;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by favianalopez on 11/7/16.
 */
public interface NewEventRepository extends PagingAndSortingRepository<NewEvent, Long> {

}
