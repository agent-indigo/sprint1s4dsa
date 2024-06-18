package com.keyin.hynes.braden.sprint1s4dsa.classes.abstracts;
import com.keyin.hynes.braden.sprint1s4dsa.interfaces.ListHandling;
public abstract class ListHandler implements ListHandling {
    protected int index;
    protected boolean found;
    protected String listNotFoundMessage;
    public ListHandler() {
        this.index = 0;
        this.found = false;
        this.listNotFoundMessage = "Error: list not found.";
    }
    @Override
    public abstract void traverse();
    @Override
    public abstract void deleteList();
}