package BinarySearch;

public class SearchInMatrix2 { // TC = O(row * log (col))
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        boolean ans = false;

        for(int i = 0 ; i<row ; i++){
            int col = matrix[i].length-1;
            if(binarySearch(matrix , target , i , col))return true;
        }
        return ans;
    }

    private boolean binarySearch(int [][]matrix , int target , int row , int col){
        int low = 0 , high = col;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}

class SearchInMatrix2Optimized {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        boolean ans = false;

        for(int i = 0 ; i<row ; i++){
            int col = matrix[i].length-1;
            if(binarySearch(matrix , target , i , col))return true;
        }
        return ans;
    }

    private boolean binarySearch(int [][]matrix , int target , int row , int col){
        int low = 0 , high = col;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[row][mid] == target){
                return true;
            }
            else if(matrix[row][mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}
