package ArrayStrings.Arrays;

//https://leetcode.com/problems/max-chunks-to-make-sorted/description
//https://www.youtube.com/watch?v=OwEggxOnszA
public class MaxChunks {

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;

        int prefixMax[] = new int[n];
        int suffixMin[] = new int[n];

        //calculate prefix Max
        prefixMax[0] = arr[0];
        for(int i = 1 ; i<n ; i++){
            prefixMax[i] = Math.max(prefixMax[i-1] , arr[i]);
        }

        //calculate suffix Min
        suffixMin[n-1] = arr[n-1];
        for(int i = n-2 ; i>=0 ; i--){
            suffixMin[i] = Math.min(suffixMin[i+1] , arr[i]);
        }

        int count = 0;
        for(int i = 0 ; i<n ; i++){
            int previous = i > 0 ? prefixMax[i-1] : -1;
            int next = suffixMin[i];
            if(previous < next)count++;
        }

        return count;
    }

    public int maxChunksToSorted_moreOptimal(int[] arr) {
        // by sum till now approach

        int sumOfNEle = 0 , currSum = 0 , chunk = 0;
        int n = arr.length;

        for(int i = 0 ; i<n ; i++){
            sumOfNEle += i;
            currSum += arr[i];
            if( sumOfNEle == currSum ){ // we are comparing total sum with sum of n element till current idx as we are given with (0 - n-1) elements , so if sum of element is eqs sum of idx  then array can be indexed
                chunk++;
            }
        }

        return chunk;
    }

    /*
    What is the Code Doing?

    The goal of this code is to divide the array into chunks where the sum of the indices of elements in that chunk equals the sum of the actual array values in that chunk.

     It compares the cumulative sum of indices (sumOfNEle) and the cumulative sum of the array elements (currSum). When these sums are equal, it means you can split the array at that point, and it counts it as one "valid chunk."
     */

}
