package com.keyin.hynes.braden.sprint1s4dsa.classes.entities;
import java.util.LinkedList;
public final class User {
    private int id;
    private String name;
    private LinkedList<Task> tasks;
    public User() {
        this.tasks = new LinkedList<Task>();
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public LinkedList<Task> getTasks() {
        return tasks;
    }
}