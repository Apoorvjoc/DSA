package ArrayStrings.Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
    public ArrayList<Integer> wave(ArrayList<Integer> A) {
        //You Can Code Here

        //NOTE: If multiple answers are possible, return the lexicographically smallest one.
        // as above NOTE is given therefore we need to sort array (only method to solve)
        int n = A.size();
        Collections.sort(A);

        for(int i = 0 ; i<n-1 ; i+=2){
            int temp = A.get(i);
            A.set(i , A.get(i+1));
            A.set(i+1 , temp);
        }

        return A;

    }
}

// if ques was given without NOTE then it can be solved by swapping adjacent elements greedily
