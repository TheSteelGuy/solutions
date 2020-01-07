package main.java.com.company;

import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        IsEmployeeAgeSimilar employee = new IsEmployeeAgeSimilar();
        Set sharedAges = employee.isAgeSimilar();
        System.out.println("shared ages::");
        System.out.println(sharedAges);
    }
}
