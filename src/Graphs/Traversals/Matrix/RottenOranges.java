package Graphs.Traversals.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
//    Explanation of Time Complexity:
//    Time Complexity: O(n * m), where n is the number of rows and m is the number of columns in the grid. This is because we process each cell at most once during the BFS traversal.
//
//    Space Complexity: O(n * m) for the queue and visited matrix, which stores the grid’s size.

    public class Pair{
        int time;
        int row;
        int col;

        public Pair(int row , int col , int time){
            this.row = row;
            this.col = col;
            this.time = time; // take care of adding time
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList();
        int n = grid.length;
        int m = grid[0].length;
        int time = 0 , cnt = 0 , freshOranges = 0;
        int axis[][] = {
                {1 , 0},
                {0 , 1},
                {-1 , 0},
                {0 , -1}
        };


        int vis[][] = new int[n][m];

        int freshAndRottenOranges = 0;
        for(int row = 0 ; row<n ; row++){
            for(int col = 0 ; col<m ; col++){
                if(grid[row][col] == 2){
                    // System.out.println("First rotten at "+row+" col "+col);
                    q.add(new Pair(row , col , 0));
                    vis[row][col] = 1;
                    // break;
                }else if(grid[row][col] == 1){
                    freshOranges++; // take care of counting fresh oranges
                }
            }
        }

        while(!q.isEmpty()){
            Pair currOrange = q.poll();

            int tm = currOrange.time;

            time = Math.max(time , tm);

            for(int i = 0 ; i < 4 ; i++){
                int nRow = currOrange.row + axis[i][0];
                int nCol = currOrange.col + axis[i][1];


                if(isValid(nRow , nCol , grid , vis)){
                    vis[nRow][nCol] = 1;
                    grid[nRow][nCol] = 2;
                    q.add(new Pair(nRow , nCol, tm+1)); // take care for this
                    cnt++;
                }
            }
        }

        if(cnt != freshOranges)return -1;

        return time;
    }

    private boolean isValid(int row , int col , int grid[][] , int vis[][]){
        int n = grid.length;
        int m = grid[0].length;

        return row >= 0 && row < n && col >= 0 && col < m && grid[row][col] == 1 && vis[row][col] == 0;
    }
}
