package BinarySearch.two_D_Matrix;

//max ones with sorted rows of matrix
//https://takeuforward.org/plus/data-structures-and-algorithm/binary-search/2d-arrays/find-row-with-maximum-1's/submissions
public class MaxOnes {
    public int rowWithMax1s(int[][] mat) {
        return rowAndMaximumOnes(mat)[0];
    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        int rows = mat.length , idx = -1;
        int ans = 0;
        for(int currRow = 0 ; currRow < rows ; currRow++){
            int col = mat[currRow].length;
            int currOneIdx = findFirstOccuranceOfOne(mat[currRow] , currRow , col);
            int currAns = col - currOneIdx;
            if(currAns > ans){
                idx = currRow;
                ans = currAns;
            }
        }
        int ansMat [] = {idx , ans};
        return ansMat;
    }

    private int findFirstOccuranceOfOne(int arr[] , int row , int col){
        int low = 0 , high = col-1 , ans = col;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid] >= 1){
                ans = mid;
                high = mid  - 1;
            }else{
                low = mid + 1;
            }
        }
        //System.out.println("ans for row : " + row + " is : "+ans);
        return ans;
    }
}
