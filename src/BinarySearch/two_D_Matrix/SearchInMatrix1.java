package BinarySearch.two_D_Matrix;

public class SearchInMatrix1 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int r = matrix.length , c = matrix[0].length;
        int low = 0 , high = r*c-1;

        while(low <= high){
            int mid = low + (high - low) / 2 ;
            int currRow = mid / c , currCol = mid % c;

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
