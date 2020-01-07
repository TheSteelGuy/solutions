package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code
        double amount = 4000;
        DistributeMoney distributor = new DistributeMoney(amount);
        distributor.distributeMoneyToEmployees();
    }
}
