package com.keyin.hynes.braden.sprint1s4dsa.classes.lists;
import com.keyin.hynes.braden.sprint1s4dsa.classes.abstracts.List;
import com.keyin.hynes.braden.sprint1s4dsa.classes.nodes.TaskNode;
public final class TaskList extends List {
    private TaskNode head;
    private TaskNode tail;
    public TaskList() {
        super();
    }
    public TaskNode getHead() {
        return head;
    }
    public void setHead(TaskNode head) {
        this.head = head;
    }
    public TaskNode getTail() {
        return tail;
    }
    public void setTail(TaskNode tail) {
        this.tail = tail;
    }
}