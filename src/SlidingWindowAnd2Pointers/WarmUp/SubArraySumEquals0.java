package SlidingWindowAnd2Pointers.WarmUp;

import java.util.HashMap;

//https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

//idea behind the logic is , if sum already exists in hashmap then sum present at last index till now (current idx)
// will be zero so we can calculate length as (current idx - last index)
public class SubArraySumEquals0 {
    static boolean findsum(int arr[]) {
        // Your code here
        HashMap<Integer , Integer> hm = new HashMap();
        int n = arr.length , sum = 0;;
        hm.put(0 , -1);

        for(int i = 0 ; i<n ; i++){
            sum += arr[i];
            if(hm.containsKey(sum))return true;
            hm.put(sum , i);
        }
        return false;
    }
}

class LargestSubArraySumLength{
    int maxLen(int arr[]) {
        // code here
        HashMap<Integer , Integer> hm = new HashMap();
        int n = arr.length , sum = 0 , maxLength = 0;
        hm.put(0 , -1);

        for(int i = 0 ; i<n ; i++){
            sum += arr[i];
            if(hm.containsKey(sum)){
                maxLength = Math.max(maxLength , i - hm.get(sum));
            }else{
                hm.put(sum , i);
            }
        }
        return maxLength;
    }
}

/*
Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5
Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].

Input: arr[] = [2, 10, 4]
Output: 0
Explanation: There is no subarray with a sum of 0.
 */
