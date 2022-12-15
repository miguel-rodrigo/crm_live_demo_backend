package com.bootcamp4.CRMLiveDemo.activity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Activity {

    public enum ActivityType{
        CALL,
        MAIL,
        MEETING
    }

    @Id
    @SequenceGenerator(name = "activity_sequence",sequenceName = "activity_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "activity_sequence")
    private Long id;

    private LocalDate date;
    private String description;

    private ActivityType activityType;

    public Activity(Long id, LocalDate date, String description, ActivityType activityType) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.activityType = activityType;
    }

    public Activity(LocalDate date, String description, ActivityType activityType) {
        this.date = date;
        this.description = description;
        this.activityType = activityType;
    }

    public Activity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", date=" + date +
                ", description='" + description + '\'' +
                ", activityType=" + activityType +
                '}';
    }
}
