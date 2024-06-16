package com.keyin.hynes.braden.sprint1s4dsa.records;
import java.util.LinkedList;
public record User(
    String name,
    LinkedList<Task> tasks
) {}