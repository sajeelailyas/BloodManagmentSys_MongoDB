package taskmanagement.model;

import org.bson.types.ObjectId;

public class project {
    private ObjectId id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private boolean isActive;

    // Constructors
    public project() {
    }

    public project(String name, String description, String startDate, String endDate, boolean isActive) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    // Getters and setters
    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    // Other methods
    public void printProjectDetails() {
        System.out.println("Project Name: " + name);
        System.out.println("Project Description: " + description);
        System.out.println("Start Date: " + startDate);
        System.out.println("End Date: " + endDate);
        System.out.println("Is Active: " + (isActive ? "Yes" : "No"));
    }
}
