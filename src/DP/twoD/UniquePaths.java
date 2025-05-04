package DP.twoD;

import java.util.Arrays;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        return helper(m - 1,  n - 1);
    }

    private int helper(int m , int n){
        if(m == 0 && n == 0)return 1;
        if(m<0 || n<0)return 0;

        int left = helper(m-1 , n);
        int right = helper(m , n-1);

        return left + right;
    }
}

class memo_topToBottom{
    private void fill(int memo[][]){
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
    }

    public int uniquePaths(int m, int n) {

        int memo[][] = new int[m][n];
        fill(memo);

        return helper(m - 1,  n - 1 , memo);

        //return memo[m-1][n-1]; --> this will also return same ans
    }

    private int helper(int m , int n , int memo[][]){
        if(m == 0 && n == 0)return 1;
        if(m<0 || n<0)return 0;

        if(memo[m][n] != -1)return memo[m][n];

        int left = helper(m-1 , n , memo);
        int right = helper(m , n-1 , memo);

        return memo[m][n] = left + right;
    }
}

class bottomUp{

    private void fill(int memo[][]){
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
    }

    private int uniquePaths(int m , int n){
        int dp[][] = new int[m][n];

        fill(dp);

        for(int i = 0 ; i<m ; i++){
            for(int j = 0 ; j<n ; j++){
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else{
                    int left = 0;
                    int right = 0;

                    if(i-1 >= 0)left = dp[i-1][j];
                    if(j-1 >= 0)right = dp[i][j-1];

                    dp[i][j] = left + right;
                }
            }
        }

        return dp[m-1][n-1];
    }
}
