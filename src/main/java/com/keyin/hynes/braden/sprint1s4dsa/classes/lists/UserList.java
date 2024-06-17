package com.keyin.hynes.braden.sprint1s4dsa.classes.lists;
import com.keyin.hynes.braden.sprint1s4dsa.classes.abstracts.List;
import com.keyin.hynes.braden.sprint1s4dsa.classes.nodes.UserNode;
public final class UserList extends List {
    private UserNode head;
    private UserNode tail;
    public UserList() {
        super();
    }
    public UserNode getHead() {
        return head;
    }
    public void setHead(UserNode head) {
        this.head = head;
    }
    public UserNode getTail() {
        return tail;
    }
    public void setTail(UserNode tail) {
        this.tail = tail;
    }
}