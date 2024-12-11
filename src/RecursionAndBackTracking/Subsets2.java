package RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/subsets-ii/ (if duplicate subset are allowed then remove sort and if condition)
//TC : (2 ^ length of arr) * length of array
//SC : The total number of subsets is 2 ^ n , and each subset can be at most n elements long.
//Thus, the space complexity for storing the subsets is
//𝑂( n * 2 ^ n).
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> sans = new ArrayList();
        Arrays.sort(nums);
        helper(0 , sans , ans , nums);
        return ans;
    }

    private void helper(int idx , List<Integer> subset , List<List<Integer>> ans , int nums[]){
        ans.add(new ArrayList(subset));

        if(idx == nums.length)return;

        for(int i = idx ; i<nums.length ; i++){
            if(i > idx && nums[i] == nums[i-1])continue;

            subset.add(nums[i]);
            helper(i+1 , subset , ans , nums);
            subset.remove(subset.size() - 1);
        }
    }
}
