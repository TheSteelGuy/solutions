package com.company;

import java.util.ArrayList;
import java.util.List;

public class DistributeMoney {
    private double amount;
    public DistributeMoney(double amount) {
        this.amount = amount;
    }

    public List distributeMoneyToEmployees() {
        List result = new ArrayList();
        if (amount >= 10) {
            double preTotal = 10;
            double currentAmount = 10;
            int employees = 1;
            while (preTotal < amount) {

                currentAmount = currentAmount * 1.12;
                preTotal += currentAmount ;

                employees += 1;
                if (preTotal > amount) {
                    preTotal = preTotal - currentAmount;
                    employees = employees - 1;
                    break;
                }

            }
            double remainder = amount - preTotal;
            System.out.println("Total employees: " + employees + " remaining amount: " + remainder);
            result.add(employees);
            result.add(remainder);
        } else
        {
           result.add("Amount must be 10 and above:-)");
           System.out.println("Amount must be 10 and above:-)");
        }
        // return values are only meant for testing
        return result;
    }

}