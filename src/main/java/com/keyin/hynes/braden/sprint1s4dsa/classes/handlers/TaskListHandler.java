package com.keyin.hynes.braden.sprint1s4dsa.classes.handlers;
import com.keyin.hynes.braden.sprint1s4dsa.classes.abstracts.ListHandler;
import com.keyin.hynes.braden.sprint1s4dsa.classes.entities.Task;
import com.keyin.hynes.braden.sprint1s4dsa.classes.lists.TaskList;
import com.keyin.hynes.braden.sprint1s4dsa.classes.nodes.TaskNode;
public final class TaskListHandler extends ListHandler {
    private TaskNode newTask;
    private TaskList list;
    private TaskNode currentTask;
    private TaskNode nextTask;
    private TaskNode previousTask;
    private String taskNotFoundMessage;
    public TaskListHandler() {
        super();
        this.newTask = new TaskNode();
        this.list = new TaskList();
        this.currentTask = list.getHead();
        this.nextTask = newTask;
        this.taskNotFoundMessage = "Error: task not found.";
    }
    public TaskList getList() {
        return list;
    }
    public void create(Task task) {
        newTask.setTask(task);
        newTask.setNext(null);
        list.setHead(newTask);
        list.setTail(newTask);
        list.setSize(1);
    }
    public void insert(
        Task task,
        int position
    ) {
        newTask.setTask(task);
        if (list.getHead() == null) {
            create(task);
            return;
        } else if (position == 0) {
            newTask.setNext(list.getHead());
            list.setHead(newTask);
        } else if (position >= list.getSize()) {
            list.getTail().setNext(newTask);
            newTask.setNext(null);
            list.setTail(newTask);
        } else {
            while (index < position - 1) {
                this.currentTask = currentTask.getNext();
                index++;
            }
            newTask.setNext(nextTask);
        }
        list.setSize(list.getSize() + 1);
    }
    @Override
    public void traverse() {
        if (list.getHead() == null) {
            System.err.println(listNotFoundMessage);
        } else {
            for (int i = 0; i < list.getSize(); i++) {
                System.out.println(currentTask.getTask().toString());
                if (index != list.getSize() - 1) {
                    System.out.println(" -> ");
                }
                this.currentTask = currentTask.getNext();
            }
        }
        System.out.println();
    }
    public boolean search(Task task) {
        if (list.getHead() != null) {
            for (int i = 0; i < list.getSize(); i++) {
                if (currentTask.getTask().equals(task)) {
                    System.out.printf("Task found at position %d.", i);
                    this.found = true;
                }
            }
        } else {
            System.err.println(taskNotFoundMessage);
        }
        return found;
    }
    public void deleteTask(Task task) {
        if (list.getHead() == null) {
            System.err.println(listNotFoundMessage);
            return;
        } else {
            while (currentTask != null && currentTask.getTask() != task) {
                this.previousTask = currentTask;
                this.currentTask = currentTask.getNext();
            }
            if (currentTask == null) {
                System.err.println(taskNotFoundMessage);
                return;
            } else {
                if (previousTask != null) {
                    previousTask.setNext(currentTask.getNext());
                } else {
                    list.setHead(currentTask.getNext());
                }
                list.setSize(list.getSize() - 1);
            }
        }
    }
    @Override
    public void deleteList() {
        list.setHead(null);
        list.setTail(null);
        list.setSize(0);
    }
}