package SlidingWindowAnd2Pointers;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/fruit-into-baskets/
// question ca be breakdown to : max length sub array with at most 2 types of number
//TC : n * n
public class FruitsIntoBasketBruteForce {
    public int totalFruit(int[] fruits) {
        int n = fruits.length , ans = 0;

        for(int i = 0 ; i<n ; i++){
            Set<Integer> s = new HashSet();
            for(int j = i ; j<n ; j++){
                s.add(fruits[j]);
                if(s.size() > 2)break;

                ans = Math.max(ans , j - i + 1);
            }
        }

        return ans;
    }
}

class FruitsIntoBasketBetter {
    public int totalFruit(int[] fruits) {
        int n = fruits.length , ans = 0;

        for(int i = 0 ; i<n ; i++){
            Set<Integer> s = new HashSet();
            for(int j = i ; j<n ; j++){
                s.add(fruits[j]);
                if(s.size() > 2)break;

                ans = Math.max(ans , j - i + 1);
            }
        }

        return ans;
    }
}
