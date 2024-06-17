package com.keyin.hynes.braden.sprint1s4dsa.classes.nodes;
import com.keyin.hynes.braden.sprint1s4dsa.classes.entities.User;
public final class UserNode {
    private User user;
    private UserNode next;
    public UserNode() {}
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public UserNode getNext() {
        return next;
    }
    public void setNext(UserNode next) {
        this.next = next;
    }
}