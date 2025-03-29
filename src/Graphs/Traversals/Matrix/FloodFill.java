package Graphs.Traversals.Matrix;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        int vis[][] = new int[n][m];
        int axis[][] = {{1, 0},{0 , 1},{-1 , 0},{0 , -1}};
        int defultColor = image[sr][sc];


        dfs(image , sr , sc , color , axis , vis , defultColor);

        return image;
    }

    private void dfs(int[][] image, int row , int col , int color , int [][]axis , int [][]vis , int defultColor){
        if(isValid(row , col , vis , image , color , defultColor) ){
            vis[row][col] = 1;
            image[row][col] = color;
            for(int i = 0 ; i < 4 ; i++){
                int nRow = row + axis[i][0];
                int nCol = col + axis[i][1];
                dfs(image , nRow , nCol , color , axis , vis , defultColor);
            }
        }
    }

    private boolean isValid(int row , int col , int [][]vis , int image[][] , int color , int defultColor ){
        int n = vis.length;
        int m = vis[0].length;

        return (row >= 0 && row < n && col >= 0 && col < m && vis[row][col] == 0 && image[row][col] == defultColor);
    }
}

class floodFill_BFS{
        public int[][] floodFill(int[][] img, int sr, int sc, int color) {
            int r = img.length, c = img[0].length;
            Queue<int[]> q = new LinkedList<>();
            int[][] vis = new int[r][c];
            int ic = img[sr][sc];
            q.add(new int[]{sr,sc});
            img[sr][sc] = color;
            vis[sr][sc] = 1;
            int dx[] = {0,0,-1,1};
            int dy[] = {-1,1,0,0};

            while(!q.isEmpty()) {
                int point[] = q.poll();
                for(int i = 0; i <dx.length; i++) {
                    int nr = point[0] + dx[i];
                    int nc = point[1] + dy[i];

                    if(nr < 0 || nc < 0 || nr>=r|| nc >=c || img[nr][nc] != ic || vis[nr][nc] == 1) continue;
                    img[nr][nc] = color;
                    vis[nr][nc] = 1;
                    q.add(new int[]{nr,nc});
                }
            }
            return img;
        }
}
