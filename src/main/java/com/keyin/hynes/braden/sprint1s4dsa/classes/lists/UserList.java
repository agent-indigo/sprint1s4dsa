package com.keyin.hynes.braden.sprint1s4dsa.classes.lists;
import com.keyin.hynes.braden.sprint1s4dsa.classes.abstracts.List;
import com.keyin.hynes.braden.sprint1s4dsa.classes.entities.User;
public final class UserList extends List {
    private User head;
    private User tail;
    public UserList() {
        super();
    }
    public User getHead() {
        return head;
    }
    public void setHead(User head) {
        this.head = head;
    }
    public User getTail() {
        return tail;
    }
    public void setTail(User tail) {
        this.tail = tail;
    }
}