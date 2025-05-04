package DP.oneD;

import java.util.Arrays;

class recursiveSol{
    public int climbStairs(int n) {
        if(n<=1)return n;

        return helper(0 , n);
    }

    private int helper(int currStep , int targetStep){
        if(currStep > targetStep) return 0;

        if(currStep == targetStep)return 1;

        return helper(currStep + 1 , targetStep) + helper(currStep + 2 , targetStep);
    }
}

public class climbingStairs {

    public int climbStairs(int n) {
        if(n<=1)return n;

        int[] mp = new int[n];
        Arrays.fill(mp , -1);

        return helper(0 , n , mp);
    }

    private int helper(int currStep , int targetStep , int mp[]){
        if(currStep > targetStep) return 0;

        if(currStep == targetStep)return 1;

        if(mp[currStep] != -1)return mp[currStep];

        int left = helper(currStep + 1 , targetStep , mp);
        int right = helper(currStep + 2 , targetStep , mp);

        mp[currStep] = left + right;

        return mp[currStep];
    }
}

class storeSol{
    public int climbStairs(int n) {
        if(n<=1)return n;

        int[] mp = new int[n];

        mp[0] = 1;
        mp[1] = 1;

        for(int i = 2 ; i<n ; i++){
            mp[i] = mp[i-1] + mp[i-2];
        }

        return mp[n];
    }
}

