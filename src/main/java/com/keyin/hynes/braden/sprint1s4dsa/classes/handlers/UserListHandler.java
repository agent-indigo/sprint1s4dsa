package com.keyin.hynes.braden.sprint1s4dsa.classes.handlers;
import com.keyin.hynes.braden.sprint1s4dsa.classes.abstracts.ListHandler;
import com.keyin.hynes.braden.sprint1s4dsa.classes.entities.User;
import com.keyin.hynes.braden.sprint1s4dsa.classes.lists.UserList;
import com.keyin.hynes.braden.sprint1s4dsa.classes.nodes.UserNode;
public final class UserListHandler extends ListHandler {
    private UserNode newUser;
    private UserList list;
    private UserNode currentUser;
    private UserNode nextUser;
    private UserNode previousUser;
    private boolean userFound;
    private String listNotFoundMessage;
    private String userNotFoundMessage;
    public UserListHandler() {
        super();
        this.newUser = new UserNode();
        this.list = new UserList();
        this.currentUser = list.getHead();
        this.nextUser = newUser;
        this.userFound = false;
        this.listNotFoundMessage = "Error: list not found.";
        this.userNotFoundMessage = "Error: user not found.";
    }
    public UserList getList() {
        return list;
    }
    public void create(User user) {
        newUser.setUser(user);
        newUser.setNext(null);
        list.setHead(newUser);
        list.setTail(newUser);
        list.setSize(1);
    }
    public void insert(
        User user,
        int position
    ) {
        newUser.setUser(user);
        if (list.getHead() == null) {
            create(user);
            return;
        } else if (position == 0) {
            newUser.setNext(list.getHead());
            list.setHead(newUser);
        } else if (position >= list.getSize()) {
            list.getTail().setNext(newUser);
            newUser.setNext(null);
            list.setTail(newUser);
        } else {
            while (index < position - 1) {
                this.currentUser = currentUser.getNext();
                index++;
            }
            newUser.setNext(nextUser);
        }
        list.setSize(list.getSize() + 1);
    }
    @Override
    public void traverse() {
        if (list.getHead() == null) {
            System.err.println(listNotFoundMessage);
        } else {
            for (int i = 0; i < list.getSize(); i++) {
                System.out.println(currentUser.getUser().toString());
                if (index != list.getSize() - 1) {
                    System.out.println(" -> ");
                }
                this.currentUser = currentUser.getNext();
            }
        }
        System.out.println();
    }
    public boolean search(User user) {
        if (list.getHead() != null) {
            for (int i = 0; i < list.getSize(); i++) {
                if (currentUser.getUser().equals(user)) {
                    System.out.printf("User found at position %d.", i);
                    this.userFound = true;
                }
            }
        } else {
            System.err.println(userNotFoundMessage);
        }
        return userFound;
    }
    public void deleteUser(User user) {
        if (list.getHead() == null) {
            System.err.println(listNotFoundMessage);
            return;
        } else {
            while (currentUser != null && currentUser.getUser() != user) {
                this.previousUser = currentUser;
                this.currentUser = currentUser.getNext();
            }
            if (currentUser == null) {
                System.err.println(userNotFoundMessage);
                return;
            } else {
                if (previousUser != null) {
                    previousUser.setNext(currentUser.getNext());
                } else {
                    list.setHead(currentUser.getNext());
                }
                list.setSize(list.getSize() - 1);
            }
        }
    }
    @Override
    public void deleteList() {
        list.setHead(null);
        list.setTail(null);
        list.setSize(0);}
}