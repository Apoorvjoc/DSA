package Graphs.Traversals.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {
    class Pair{
        int row;
        int col;

        Pair(int row , int col){
            this.row = row;
            this.col = col;
        }
    }

    public int numEnclaves(int[][] grid) {
        // mark all cells which are not valid as 1 and then traverse again to count
        // for marking we will use visited matrix , will not touch given data

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int vis[][] = new int[n][m];

        // vist all boundary and mark all faulted cell and its neighbours as 0
        // visiting top row
        for(int row = 0 , col = 0 ; col < m ; col++){
            if(grid[row][col] == 1){q.add(new Pair(row , col)); vis[row][col] = 1;}
        }

        // visiting left col
        for(int row = 0 , col = 0 ; row < n ; row++){
            if(grid[row][col] == 1){q.add(new Pair(row , col)); vis[row][col] = 1;}
        }

        // visiting bottom row
        for(int row = n-1 , col = 0 ; col < m ; col++){
            if(grid[row][col] == 1){q.add(new Pair(row , col)); vis[row][col] = 1;}
        }

        // visiting right col
        for(int row = 0 , col = m-1 ; row < n ; row++){
            if(grid[row][col] == 1){q.add(new Pair(row , col)); vis[row][col] = 1;}
        }

        bfs(q , vis , grid);

        int count = 0;

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(vis[i][j] == 0 &&  grid[i][j] == 1)count++;
            }
        }

        return count;
    }

    private void bfs(Queue<Pair> q , int [][]vis , int [][]grid){

        int axis[][] = {{1,0} , {0,1} , {-1,0} , {0,-1}};

        while(!q.isEmpty()){
            Pair front = q.poll();
            int row = front.row;
            int col = front.col;

            // visiting all 4 directions
            for(int i = 0 ; i<4 ; i++){
                int nRow = row + axis[i][0];
                int nCol = col + axis[i][1];

                if(isValid(nRow , nCol , vis , grid)){
                    vis[nRow][nCol] = 1;
                    q.add(new Pair(nRow , nCol));
                }
            }

        }
    }

    private boolean isValid(int row , int col , int [][]vis , int [][]grid){
        int n = grid.length;
        int m = grid[0].length;

        if(row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == 0 && grid[row][col] == 1)return true;
        return false;
    }
}
