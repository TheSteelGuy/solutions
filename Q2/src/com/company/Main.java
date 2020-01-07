package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Enter amount of Money you wish to classify::");
        Scanner scanner = new Scanner(System.in);
        int countMoney;
        // money value is the value associated with either Coin or Note
        int moneyValue = 0;
        // either Coin or Note
        String moneyType="";
        // countMoney refers to the cumulative Coin and Note user will key in
        countMoney = scanner.nextInt();
        //Coin bag object
        Bag<Coin> coinBag=new Bag<Coin>();
        //Note bag Object
        Bag<Note> noteBag=new Bag<Note>();
        for(int i=0;i<countMoney;i++)
        {
            moneyType = scanner.next().toLowerCase();
            moneyValue = scanner.nextInt();
            switch(moneyType)
            {

                case  "note":
                    Note note=new Note();

                    note.setValue(moneyValue);
                    noteBag.add(note);
                    break;
                case  "coin":
                    Coin coin=new Coin();

                    coin.setValue(moneyValue);
                    coinBag.add(coin);
                    break;
                default:
                    System.out.println("Wrong in put format: Either Coin value or Note value");
            }
        }
        System.out.println("Coins :");
        coinBag.showBagContent();
        System.out.println("Notes :");
        noteBag.showBagContent();
    }
}