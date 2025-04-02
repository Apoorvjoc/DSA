package Graphs.Traversals.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMat {    class Triplet{
    int row;
    int col;
    int dist;

    Triplet(int row , int col , int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

    public int[][] updateMatrix(int[][] mat) {
        Queue<Triplet> q = new LinkedList();
        int n = mat.length;
        int m = mat[0].length;
        int vis[][] = new int[n][m];
        int distMat[][] = new int[n][m];

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new Triplet(i , j , 0)); // initial distance will be 0
                }
            }
        }

        int axis[][] = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!q.isEmpty()){
            Triplet front = q.poll();
            int row = front.row;
            int col = front.col;
            int dist = front.dist;

            distMat[row][col] = dist;

            //add all valid cells in matrix
            for(int i = 0 ; i<4 ; i++){
                int nRow = row + axis[i][0];
                int nCol = col + axis[i][1];
                if(isValidCell(nRow , nCol , vis)){
                    q.add(new Triplet(nRow , nCol , dist+1));
                    vis[nRow][nCol] = 1;
                }
            }

        }

        return distMat;

    }

    private boolean isValidCell(int row , int col , int [][]vis){
        int n = vis.length;
        int m = vis[0].length;

        if(row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == 0)return true;
        return false;
    }
}
