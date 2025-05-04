package DP.oneD;

public class HouseRobber2 {
    public int rob(int[] nums) {
        // making 2 arrays such that 0th and n-1th idx should not come as adjacent
        int n = nums.length;

        if(n == 1)return nums[0];

        int temp1[] = new int[n-1]; // as we are skipping one element from array therefore array size will be one less then original
        int temp2[] = new int[n-1];

        // creating 2 arrays
        int temp1i = 0 , temp2i = 0;
        for(int i = 0 ; i<n ; i++){
            if(i != 0)temp1[temp1i++] = nums[i];
            if(i != n-1)temp2[temp2i++] = nums[i];
        }

        return Math.max(houseRobber1(temp1) , houseRobber1(temp2));
    }

    private int houseRobber1(int nums[]){
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = nums[0];

        for(int i = 1 ; i<n ; i++){
            int take = nums[i];
            if(i-2>=0)take += dp[i-2];
            int notTake = 0 + dp[i-1];

            dp[i] = Math.max(take , notTake);
        }

        return dp[n-1];
    }
}
