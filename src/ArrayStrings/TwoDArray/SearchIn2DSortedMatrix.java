package ArrayStrings.TwoDArray;

public class SearchIn2DSortedMatrix {

    public boolean searchMatrix_optimal(int[][] matrix, int target) {
        //search from right top corner
        int row = matrix.length;
        int col = matrix[0].length;
        int sRow = 0 , sCol = col-1;

        while(sCol>=0 && sCol<col && sRow>=0 && sRow<row){
            if(matrix[sRow][sCol] == target)return true;
            else if(target < matrix[sRow][sCol])sCol--;
            else sRow ++;
        }

        return false;
    }
}
