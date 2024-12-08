package BinarySearch;

public class SearchInSortedMatrixAp1 {

    public static void main(String[] args) {
        SearchInSortedMatrixAp2 ob = new SearchInSortedMatrixAp2();
        int[][] matrix = {{1}};
        ob.searchMatrix(matrix , 2);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;

        for(int i = 0 ; i<row ; i++){
            int col = matrix[i].length-1;

            if(matrix[i][0] <= target && target <= matrix[i][col]){
                return binarySearch(matrix , target , i , col);
            }
        }

        return false;
    }

    private boolean binarySearch(int [][]matrix , int target , int row , int col){
        int low = 0 , high = col;

        while(low <= high){
            int mid = low + (high - low) / 2;
            if(matrix[row][mid] == target)return true;
            else if(matrix[row][mid] < target) low = mid + 1;
            else high = mid - 1;
        }

        return false;
    }
}

class SearchInSortedMatrixAp2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length , c = matrix[0].length;
        int low = 0 , high = r*c - 1;

        while(low <= high){
            int mid = low + (high - low) / 2 ;
            int currRow = mid / c , currCol = mid % c; // key to remember

            if(matrix[currRow][currCol] == target)return true;
            else if(matrix[currRow][currCol] < target){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return false;
    }
}


