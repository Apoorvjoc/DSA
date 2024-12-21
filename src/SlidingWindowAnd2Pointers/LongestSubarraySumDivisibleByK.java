package SlidingWindowAnd2Pointers;

import java.util.HashMap;

public class LongestSubarraySumDivisibleByK {
    int longSubarrWthSumDivByK(int[] nums, int k) {
        // Complete the function
        int ans = 0 , n = nums.length , sum = 0;
        HashMap<Integer , Integer> hm = new HashMap();
        hm.put(0 , -1);

        for(int i = 0 ; i<n ; i++){
            sum += nums[i];
            int rem = sum % k;

            if(rem < 0) rem += k; // handling -ve rem

            if(hm.containsKey(rem)){
                int idx = hm.get(rem);
                int len = i - idx;
                ans = Math.max(len , ans);
            }else{
                hm.put(rem , i);
            }
        }
        return ans;
    }
}
