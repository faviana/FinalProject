package ironyard.controller;

import ironyard.data.Permission;
import ironyard.repositories.PermissionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by favianalopez on 11/29/16.
 */
@RestController
@RequestMapping(path = "/rest/permission")
public class RestPermissionController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PermissionRepository permissionRepository;

    /**
     * save the permission
     * @param permission object being saved
     * @return return the permission found by id
     */

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public Permission save(@RequestBody Permission permission) {
        permissionRepository.save(permission);
        return permissionRepository.findOne(permission.getId());
    }

    /**
     * update permission
     * @param permission object being updated
     * @return return the permission found by id
     */

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public Permission update(@RequestBody Permission permission) {
        permissionRepository.save(permission);
        return permissionRepository.findOne(permission.getId());
    }

    /**
     * retrieve the permission by id and return it
     * @param id id of permission being retrieved
     * @return return permission found by id
     */

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Permission show(@PathVariable Long id) {
        return permissionRepository.findOne(id);

    }

    /**
     * iterate through list of permissions
     * @return return list of permissions
     */

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public Iterable<Permission> listAll(){
        return permissionRepository.findAll();
    }

    /**
     * delete permission
     * @param id id of permission being deleted
     * @return return deleted permission
     */

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public Permission delete(@PathVariable Long id) {
        Permission deletedPermission = permissionRepository.findOne(id);
        permissionRepository.delete(id);
        return deletedPermission;
    }

    /**
     * handle exception
     * @param exception exception found
     * @return error message
     */

    @ExceptionHandler(value = Throwable.class)
    public String nfeHandler(Throwable exception) {
        return "There was an error :/";
    }
}
