package ArrayStrings.Arrays;

//https://leetcode.com/problems/find-the-duplicate-number/description/
/*
Input: nums = [1,3,4,2,2]
Output: 2
 */
public class DuplicateNumberInArray {


    public int findDuplicate_withArrayModification(int[] nums) {
        int n = nums.length;

        for(int i = 0 ; i<n ; i++){
            int idx = Math.abs(nums[i]);
            if(nums[idx] < 0)return idx;
            nums[idx] = -nums[idx];
        }

        return 0;
    }

    // if given array cant be modified then use this otherwise above approach is good
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
