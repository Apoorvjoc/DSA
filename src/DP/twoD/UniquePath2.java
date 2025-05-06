package DP.twoD;

import java.util.Arrays;

public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        return helper(n-1 , m-1 , obstacleGrid);
    }

    private int helper(int row , int col , int [][]grid){
        if(row == 0 && col == 0)return 1;
        if(row < 0 || col < 0 || grid[row][col] == 1)return 0;

        int left = helper(row-1 ,  col , grid);
        int top = helper(row ,  col-1 , grid);

        return left + top;
    }
}

class UniquePath2_memo{

    private void fill (int memo[][]){
        for(int [] arr : memo){
            Arrays.fill(arr , -1);
        }
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        int memo[][] = new int[n][m];

        fill(memo);

        return helper(n-1 , m-1 , obstacleGrid  , memo);
    }

    private int helper(int row , int col , int [][]grid , int memo[][]){
        if(row < 0 || col < 0 || grid[row][col] == 1)return 0; // this will handle condition if condition is [[1]]
        if(row == 0 && col == 0)return 1; // this condition should be second one , as this might be a case that we have only one element and the element is 1 , e.g : [[1]]

        if(memo[row][col] != -1)return memo[row][col];

        int left = helper(row-1 ,  col , grid , memo);
        int top = helper(row ,  col-1 , grid , memo);

        return memo[row][col] = left + top;
    }
}

class top_bottom_tabulation{

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        if(obstacleGrid[0][0] == 1)return 0;

        int dp[][] = new int[n][m];

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(i == 0 && j == 0)dp[i][j] = 1;
                else if(obstacleGrid[i][j] != 1){
                    int left = 0 , right = 0;
                    if(i-1 > 0){
                        left = dp[i-1][j];
                    }
                    if(j-1>0){
                        right = dp[i][j-1];
                    }
                    dp[i][j] = left + right;
                }
            }
        }
        return dp[n-1][m-1];
    }

}
