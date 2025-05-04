package DP.oneD;

import java.util.Arrays;

public class HouseRobber1 {
    //recursive soln : TC : o(2^n) , sc : o(n)

    public int rob(int[] nums) {
        // Start from the last index of the array (last house)
        return helper(nums, nums.length - 1);
    }

    // Recursive helper function to decide whether to rob or skip a house
    private int helper(int[] nums, int idx) {
        // Base case: only one house to rob (index 0)
        if (idx == 0) return nums[idx];

        // Base case: index is out of bounds (e.g., -1 or -2), return 0 (no money)
        if (idx < 0) return 0;

        // Option 1: Rob the current house and move to the house two steps before
        int take = nums[idx] + helper(nums, idx - 2);

        // Option 2: Skip the current house and move to the previous one
        int notTake = helper(nums, idx - 1);

        // Return the maximum money between robbing or skipping this house
        return Math.max(take, notTake);
    }

}

class memo_topToBottom{
    // tc : o(n) , sc : o(n) + o(n) => for recursion and memo array
    public int rob(int[] nums) {
    // Start from the last index of the array (last house)
        int n = nums.length;
        int memo[] = new int[n];
        Arrays.fill(memo , -1);
        return helper(nums, n-1 , memo);
    }

    // Recursive helper function to decide whether to rob or skip a house
    private int helper(int[] nums, int idx , int memo[]) {
        //base case
        if (idx == 0) return nums[idx];
        if (idx < 0) return 0;

        if(memo[idx] != -1)return memo[idx]; // memo step

        int take = nums[idx] + helper(nums, idx - 2 ,  memo);
        int notTake = helper(nums, idx - 1 , memo);

        return memo[idx] = Math.max(take, notTake); // memo step
    }

}

class tabulation_BottomUp{

    //TC : o(N) , sc o(N)
    public int rob(int[] nums) {
        // Start from the last index of the array (last house)
        int n = nums.length;
        int dp[] = new int[n];

        dp[0] = nums[0]; // base case of recursion

        for(int i = 1 ; i<n ; i++){
            int take = nums[i]; // TODO : take care of this step
            if(i - 2 >= 0) take += dp[i-2];
            int notTake = 0 + dp[i-1];

            dp[i] = Math.max(take, notTake);
        }

        return dp[n-1];
    }
}

class SpaceOptimization{
    public int rob(int[] nums) {
        int n = nums.length;

        // Handle edge cases
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        // Initialize previous two results
        int prev2 = nums[0]; // Equivalent to dp[i-2]
        int prev1 = Math.max(nums[0], nums[1]); // Equivalent to dp[i-1]

        // Loop from house 2 to the last house
        for (int i = 2; i < n; i++) {
            // Rob current house + value two steps back
            int take = nums[i] + prev2;

            // Skip current house
            int notTake = prev1;

            // Calculate current max and update previous values
            int current = Math.max(take, notTake);
            prev2 = prev1;
            prev1 = current;
        }

        // The last value is the answer
        return prev1;
    }
}
