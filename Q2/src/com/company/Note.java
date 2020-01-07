package com.company;

public class Note implements MoneyInterface {
    int val;
    public void setValue(int val)
    {
        this.val=val;
    }
    public int getValue()
    {
        return this.val;
    }
}