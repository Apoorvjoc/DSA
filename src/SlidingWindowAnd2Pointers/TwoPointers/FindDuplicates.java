package SlidingWindowAnd2Pointers.TwoPointers;

//https://leetcode.com/problems/find-the-duplicate-number/description/
public class FindDuplicates {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        for(int i = 0 ; i<n ; i++){
            int idx = Math.abs(nums[i]);
            if(nums[idx] < 0)return idx;
            nums[idx] = -nums[idx];
        }

        return 0;
    }
}

// we are not allowed to modify array then we should proceed to following approach
//linear and without modifying
//Floyd's Tortoise and Hare algorithm (generally used when we have to find duplicate (cycle))
class findDuplicateOptimal{
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = nums[0] , fast = nums[0];
        slow = nums[slow] ;
        fast = nums[nums[fast]]; // moving fast pointer with 2 steps

        while(slow != fast){
            slow = nums[slow] ;
            fast = nums[nums[fast]]; // moving fast pointer with 2 steps
        }

        slow = nums[0];

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // you can pass ans as fast too as both of them are at same index
    }
}
