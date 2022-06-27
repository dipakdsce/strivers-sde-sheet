package com.company.utility;

public class ListNodeMod {
    public int val;
    public ListNodeMod next;
    public ListNodeMod bottom;

    public ListNodeMod() {}

    public ListNodeMod(int val) {
        this.val = val;
        this.bottom = null;
        this.next = null;
    }

    public ListNodeMod(int val, ListNodeMod next) {
        this.val = val;
        this.next = next;
        this.bottom = null;
    }

    /*public ListNodeMod(int val, ListNodeMod bottom) {
        this.val = val;
        this.bottom = bottom;
        this.next = null;
    }*/

    public ListNodeMod(int val, ListNodeMod bottom, ListNodeMod next) {
        this.val = val;
        this.bottom = bottom;
        this.next = next;
    }
}
