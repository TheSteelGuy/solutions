package com.company;

// Java Class for Coin
public class Coin implements MoneyInterface {
    int moneyValue;
    public void setValue(int value)
    {
        this.moneyValue =value;
    }
    public int getValue()
    {
        return this.moneyValue;
    }
}
