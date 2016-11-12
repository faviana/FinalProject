package ironyard.data;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by favianalopez on 11/8/16.
 */
@Entity
public class EventPlanner {
    private String username;
    private String password;
    private String displayName;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<NewEvent> events;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public EventPlanner(String username, String password, String displayName) {
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    public EventPlanner() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<NewEvent> getEvents() {
        return events;
    }

    public void setEvents(Set<NewEvent> events) {
        this.events = events;
    }
}
