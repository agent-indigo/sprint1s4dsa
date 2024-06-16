package com.keyin.hynes.braden.sprint1s4dsa.records;
import com.keyin.hynes.braden.sprint1s4dsa.enums.Status;
public record Task(
    String description,
    Status status
) {}