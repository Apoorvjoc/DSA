package SlidingWindowAnd2Pointers.BinarySubarraysWithSum;

import java.util.HashMap;

public class N2BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // [count <=k ] - [count <= (k-1)] = count [k]
        return calcCount(nums,  goal) - calcCount(nums,  goal-1);
    }

    private int calcCount(int nums[] ,int k){
        if(k < 0)return 0;
        int l = 0 , r = 0 , ans = 0 , n = nums.length , sum = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        while(r<n){
            int ele = nums[r];
            hm.put(ele , hm.getOrDefault(ele , 0) + 1);
            sum+=ele;

            while(sum > k){
                int lele = nums[l];
                sum-=lele;
                l++;
            }
            ans += (r - l + 1);
            r++;
        }
        return ans;
    }
}
