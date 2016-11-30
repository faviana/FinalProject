package ironyard.data;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 * Created by favianalopez on 11/7/16.
 */
@Entity
public class NewEvent {

    private String nameOfEvent;
    private String budget;
    private int numberOfGuests;
    private String dateOfEvent;
    private String timeOfEvent;
    private String location;
    private String food;
    private String drinks;
    private String desserts;
    private String decorations;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public NewEvent() {
    }

    public NewEvent(String nameOfEvent, String budget, int numberOfGuests, String dateOfEvent, String timeOfEvent, String location, String food, String drinks, String desserts, String decorations) {
        this.nameOfEvent = nameOfEvent;
        this.budget = budget;
        this.numberOfGuests = numberOfGuests;
        this.dateOfEvent = dateOfEvent;
        this.timeOfEvent = timeOfEvent;
        this.location = location;
        this.food = food;
        this.drinks = drinks;
        this.desserts = desserts;
        this.decorations = decorations;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrinks() {
        return drinks;
    }

    public void setDrinks(String drinks) {
        this.drinks = drinks;
    }

    public String getDesserts() {
        return desserts;
    }

    public void setDesserts(String desserts) {
        this.desserts = desserts;
    }

    public String getDecorations() {
        return decorations;
    }

    public void setDecorations(String decorations) {
        this.decorations = decorations;
    }

    public String getNameOfEvent() {
        return nameOfEvent;
    }

    public void setNameOfEvent(String nameOfEvent) {
        this.nameOfEvent = nameOfEvent;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public String getDateOfEvent() {
        return dateOfEvent;
    }

    public void setDateOfEvent(String dateOfEvent) {
        this.dateOfEvent = dateOfEvent;
    }

    public String getTimeOfEvent() {
        return timeOfEvent;
    }

    public void setTimeOfEvent(String timeOfEvent) {
        this.timeOfEvent = timeOfEvent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}