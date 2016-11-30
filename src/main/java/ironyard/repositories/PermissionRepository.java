package ironyard.repositories;

import ironyard.data.Permission;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by favianalopez on 11/29/16.
 */
public interface PermissionRepository extends PagingAndSortingRepository<Permission,Long> {

}
