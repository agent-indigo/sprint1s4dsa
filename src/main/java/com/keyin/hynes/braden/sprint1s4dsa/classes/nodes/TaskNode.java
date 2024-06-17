package com.keyin.hynes.braden.sprint1s4dsa.classes.nodes;
import com.keyin.hynes.braden.sprint1s4dsa.classes.entities.Task;
public final class TaskNode {
    private Task task;
    private TaskNode next;
    public TaskNode() {}
    public Task getTask() {
        return task;
    }
    public void setTask(Task task) {
        this.task = task;
    }
    public TaskNode getNext() {
        return next;
    }
    public void setNext(TaskNode next) {
        this.next = next;
    }
}