package SlidingWindowAnd2Pointers;

import java.util.HashMap;

public class CountSubArrayDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        int ans = 0 , n = nums.length , sum = 0;
        HashMap<Integer , Integer> hm = new HashMap();
        hm.put(0 , 1); //one array with 0 sum is present

        for(int i = 0 ; i<n ; i++){
            sum += nums[i];
            int rem = sum % k;

            if(rem < 0) rem += k; // handling -ve rem

            if(hm.containsKey(rem)){
                ans += hm.get(rem);
            }
            hm.put(rem , hm.getOrDefault(rem , 0) + 1);

        }
        return ans;
    }
}
