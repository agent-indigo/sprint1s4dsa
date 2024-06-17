package com.keyin.hynes.braden.sprint1s4dsa.classes.abstracts;
import com.keyin.hynes.braden.sprint1s4dsa.interfaces.ListSizeAccess;
public abstract class List implements ListSizeAccess {
    protected int size;
    public List() {
        this.size = 0;
    }
    @Override
    public final int getSize() {
        return size;
    }
    @Override
    public final void setSize(int size) {
        this.size = size;
    }
}