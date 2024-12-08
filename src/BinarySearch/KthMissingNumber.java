package BinarySearch;

//given array sorted
public class KthMissingNumber {
    public int findKthPositiveBruteForce(int[] arr, int k) {
        int initialK = k;
        for(int ele : arr){
            if(ele > k)return k;
            k++;
        }
        return arr.length + initialK;
    }

    public int findKthPositive(int[] arr, int k) {
        int initialK = k;
        for(int ele : arr){
            if(ele > k)return k;
            k++;
        }
        return arr.length + initialK;
    }

    // using binary search


}
