package Graphs.Matrix;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int cnt = 0;

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(vis[i][j] == 0  && grid[i][j] == '1') {
                    dfs(i , j , grid , vis);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void  dfs(int row , int col , char [][]grid , int [][]vis){
        if(isValid(row , col , vis , grid) ){
            vis[row][col] = 1;
            dfs(row+1 , col , grid , vis);
            dfs(row , col+1 , grid , vis);
            dfs(row-1 , col , grid , vis);
            dfs(row , col-1 , grid , vis);
        }
    }

    private boolean isValid(int row , int col , int [][]vis , char grid[][]){
        int n = vis.length;
        int m = vis[0].length;

        return (row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == 0 && grid[row][col] == '1');
    }

}

class NumberOfIslands_optimal {

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int cnt = 0;
        int[][] axis = {{1 , 0} , {0 , 1} , {-1 , 0} , {0 , -1}};

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(vis[i][j] == 0  && grid[i][j] == '1') {
                    dfs(i , j , grid , vis , axis);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    public void  dfs(int row , int col , char [][]grid , int [][]vis , int[][] axis){
        if(isValid(row , col , vis , grid) ){
            vis[row][col] = 1;
            for(int i = 0 ; i<4 ; i++){
                int newRow = row + axis[i][0]; // ROW + 1 can be replaced as
                int newCol = col + axis[i][1]; // COL + 1 can be replaced as
                dfs(newRow, newCol, grid, vis, axis); // Recursively visit the neighbors
            }
        }
    }

    private boolean isValid(int row , int col , int [][]vis , char grid[][]){
        int n = vis.length;
        int m = vis[0].length;

        return (row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == 0 && grid[row][col] == '1');
    }

}

