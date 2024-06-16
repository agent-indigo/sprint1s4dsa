package com.keyin.hynes.braden.sprint1s4dsa.records;
public record TaskList(
    int size,
    Task head,
    Task tail
) {}