package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] cards = {
                "4556364607935616", "4556-3646-0793-5616", "64607935616", "ABCD-EFGH-IJKLM-NOPQ",
                "A1234567BCDEFG89HI","Skippy ",""
        };
        for (int i=0;i<cards.length;i++)
        {
            MaskCard pci = new MaskCard();
            String result = pci.mask(cards[i]);

            System.out.println(result);
        }
        System.out.println("If you wish to mask more cards, please key them in one by one::");
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit)
        {
            String nextCard = scanner.next();
            if(nextCard.equals("q")| nextCard.equals("Q"))
            {
                quit = true;
            }else{
                MaskCard pci = new MaskCard();
                System.out.println(pci.mask(nextCard));
                System.out.println("press q to exit or another card for masking::");
            }
        }

    }
}
