package main.java.com.company;

import java.util.*;

public class IsEmployeeAgeSimilar {

    Integer[] females = new Integer[]{17,22,25,29,32,34,35,45,59};
    Integer[] males = new Integer[]{17,19,20,22,27,45,56,59,69};
    Set<Integer> sharedAges = new HashSet<>();

    // Convert integer Array to List
    List<Integer> femaleList = Arrays.asList(females);


    public Set isAgeSimilar()
    {
        for (int i=0; i < males.length; i++)
        {
            if(femaleList.contains(males[i]))
            {
                sharedAges.add(males[i]);

            }
        }
        return sharedAges;

    }
}

/*
Explanation!
- I first initialize the two arrays the choose (on in this case i chose females array) to change it from an array to a LIST
which can enable me use the contains method for checking membership
- I then go  a head and loop through females list each time checking if the current value at index i of the males array exists
in the females List
- If it does not exist i do nothing if it does i add it to the shared ages Set
- I do this for every member in the males' Array
NB, i chose to use Set due to its ability to ignore duplicates
I then return the the set to the main function where I print it

 */