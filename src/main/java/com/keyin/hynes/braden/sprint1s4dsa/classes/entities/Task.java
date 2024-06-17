package com.keyin.hynes.braden.sprint1s4dsa.classes.entities;
import com.keyin.hynes.braden.sprint1s4dsa.enums.Status;
public final class Task {
    private int id;
    private String description;
    private Status status;
    public Task() {}
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "ID         : " + id + "\nDescription: " + description + "\nStatus     : " + status.toString();
    }
}