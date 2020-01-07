package com.company;

import java.util.ArrayList;
// Generic Bag Class for both Coin and Note
public class Bag <T extends MoneyInterface> {

    ArrayList<T> bag =new ArrayList<T>();
    public void add(T obj)
    {
        bag.add(obj);
    }
    public ArrayList<T> getBag() {
        return bag;
    }
    public ArrayList showBagContent()
    {
        for(T obj : bag)
        {
            System.out.println(obj.getValue());
        }
        // the return value is purely for test case
        return bag;
    }
}
