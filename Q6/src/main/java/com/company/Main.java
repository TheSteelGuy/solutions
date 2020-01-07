package main.java.com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int passMark = 38;
        Integer[] scores = new Integer[]{27,39,71,52,63,73,83,65, 56, 67};
        Grade gradeObj = new Grade();
        System.out.println("......................:");

        for (int i=0; i < scores.length; i++)
        {
            // rounding off does so in order of O(n)
            int grade = gradeObj.roundOff(scores[i], passMark);
            if (grade > 0)
            {
                scores[i] = grade;
            }
        }
        // Array.sort is O(nlogn) which i abit slower
        Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));
    }
}
