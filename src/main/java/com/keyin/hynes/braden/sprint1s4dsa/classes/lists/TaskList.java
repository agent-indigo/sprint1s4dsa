package com.keyin.hynes.braden.sprint1s4dsa.classes.lists;
import com.keyin.hynes.braden.sprint1s4dsa.classes.abstracts.List;
import com.keyin.hynes.braden.sprint1s4dsa.classes.entities.Task;
public final class TaskList extends List {
    private Task head;
    private Task tail;
    public TaskList() {
        super();
    }
    public Task getHead() {
        return head;
    }
    public void setHead(Task head) {
        this.head = head;
    }
    public Task getTail() {
        return tail;
    }
    public void setTail(Task tail) {
        this.tail = tail;
    }
}