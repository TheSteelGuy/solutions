package com.company;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class CoinTest {

    @Test
    public void testSetCoinAndGetCoinValueSetsAndGetsValue()
    {
        Coin coin = new Coin();
        coin.setValue(23);
        assertEquals(coin.getValue(), 23);
    }

    @Test
    public void testSetCoinAndGetCoinValueFails()
    {
        Coin coin = new Coin();
        coin.setValue(23);
        assertNotEquals(coin.getValue(), 53);
    }

    @Test
    public void testAddCoinToTheBagWorks()
    {
        Coin coin = new Coin();
        coin.setValue(45);
        Bag bag = new Bag();
        bag.add(coin);

        // lets assert that the coin object has been stored
        assertEquals(bag.getBag().get(0), coin);
        Coin coin2 = new Coin();
        coin2.setValue(50);
        bag.add(coin2);
        // confirm that indeed the next coin was added and it defers with the first
        assertNotEquals(bag.getBag().get(0), coin2);
    }

    @Test
    public void testDisplayBagContentWorks()
    {
        Coin coin = new Coin();
        Coin coin2 = new Coin();
        coin2.setValue(50);
        coin.setValue(45);
        Bag bag = new Bag();
        bag.add(coin);
        bag.add(coin2);
        ArrayList<Coin> bagList =new ArrayList<Coin>();
        bagList.add(coin);
        bagList.add(coin2);
        // confirm that indeed the next coin was added and it defers with the first
        assertEquals(bag.showBagContent(), bagList);
    }



}