package Graphs.Matrix;


//https://leetcode.com/problems/surrounded-regions/
public class SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];

        // go to all bounderies and mark 'O' as 1 as they can be converted to 'X' as pe logic
        //top row
        for(int row = 0 , col = 0 ; col < m ; col++ ){
            if(board[row][col] == 'O'){
                dfs(row , col , board , vis);
            }
        }

        //left col
        for(int row = 0 , col = 0 ; row < n ; row++ ){
            if(board[row][col] == 'O'){
                dfs(row , col , board , vis);
            }
        }

        //bottom row
        for(int row = n-1 , col = 0 ; col < m ; col++ ){
            if(board[row][col] == 'O'){
                dfs(row , col , board , vis);
            }
        }

        //right col
        for(int row = 0 , col = m-1 ; row < n ; row++ ){
            if(board[row][col] == 'O'){
                dfs(row , col , board , vis);
            }
        }

        // when all boundary cells with '0' are marked as 1 then , now check for remaining 'O'\

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(vis[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

    }

    // O(n * m) * 4[4 dfs call for m * n matrix] * O(N) [for 4 boundaries]
    private void dfs(int row , int col , char board[][] , int vis[][]){

        if(isValid(row , col , board , vis)){
            vis[row][col] = 1;
            dfs(row + 1 , col , board , vis);
            dfs(row , col+1 , board , vis);
            dfs(row - 1 , col , board , vis);
            dfs(row , col-1 , board , vis);
        }

    }

    private boolean isValid(int row , int col , char[][] board , int[][] vis){
        int n = board.length;
        int m = board[0].length;

        if(row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == 0 && board[row][col] == 'O')return true;
        return false;
    }
}
