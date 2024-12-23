package SlidingWindowAnd2Pointers.BinarySubarraysWithSum;

public class N1LongestSubarrayWithSumK {
    int longestSubarrayWithSumK(int []arr, long k) {
        // Write your code here
        int l = 0 , r = 0 , n = arr.length , ans = 0 , sum = 0;

        for(int i = 0 ; i<n ; i++){
            sum = 0;
            for(int j = i ; j<n ; j++){
                sum += arr[j];
                if(sum == k){
                    ans = Math.max(ans , j - i + 1);
                }else if(sum > k) break; // given all array elements are +ve therefore we can break loop as anything added to sum will increase sum (as no -ve numbers are present in array)
            }
        }

        return ans;
    }
}
class N1LongestSubarrayWithSumK_Optimal {
    int longestSubarrayWithSumK(int []arr, long k) {
        // Write your code here
        int l = 0 , r = 0 , n = arr.length , ans = 0 , sum = 0;

        for(int i = 0 ; i<n ; i++){
            sum = 0;
            for(int j = i ; j<n ; j++){
                sum += arr[j];
                if(sum == k){
                    ans = Math.max(ans , j - i + 1);
                }else if(sum > k) break; // given all array elements are +ve therefore we can break loop as anything added to sum will increase sum (as no -ve numbers are present in array)
            }
        }

        return ans;
    }
}
