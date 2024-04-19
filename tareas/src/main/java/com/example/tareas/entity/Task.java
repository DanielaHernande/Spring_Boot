package com.example.tareas.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 255, nullable = true)
    private String description;

    private LocalDate dateCreation;
    private LocalTime hourCreation;

    @Column(length = 50, nullable = true)
    private String state;

    // Constructores

    public Task() {
    }

    public Task(Long id, String title, String description, LocalDate dateCreation, LocalTime hourCreation,
            String state) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.dateCreation = dateCreation;
        this.hourCreation = hourCreation;
        this.state = state;
    }

    // Metodos getters and setters
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }


    public void setTitle(String title) {
        this.title = title;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDate getDateCreation() {
        return dateCreation;
    }


    public void setDateCreation(LocalDate dateCreation) {
        this.dateCreation = dateCreation;
    }


    public LocalTime getHourCreation() {
        return hourCreation;
    }


    public void setHourCreation(LocalTime hourCreation) {
        this.hourCreation = hourCreation;
    }


    public String getState() {
        return state;
    }


    public void setState(String state) {
        this.state = state;
    }

    // toString
    @Override
    public String toString() {
        return "Task [id=" + id + ", title=" + title + ", description=" + description + ", dateCreation=" + dateCreation
                + ", hourCreation=" + hourCreation + ", state=" + state + "]";
    }
    
}
