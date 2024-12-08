package RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combination-sum/description/

//TC : if we have n element in array and each element has 2 choices to pick and not pick then defiantly
// TC would be 2 ^ n , but here we can pick element multiple times which means if k = 10 and element = [1]
// now ro make target as 10 we need to add 1 + 1 + 1 + .... + 1 (10 times) so 2 ^ k
// TC : 2 ^ k * k [k for copy of sans to ans]
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList();
        helper(0 , 0 , new ArrayList() , ans , candidates , target);
        return ans;
    }

    private void helper(int idx , int sum , List<Integer> sans , List<List<Integer>> ans , int[] candidates, int target){
        if(sum > target || idx >= candidates.length)return;

        if(sum == target){
            ans.add(new ArrayList(sans));
            return;
        }

        sum+=candidates[idx];
        sans.add(candidates[idx]);
        helper(idx , sum , sans , ans , candidates , target); // sum with current element as one element can be taken multiple times

        //backtrack
        sum-=candidates[idx];
        sans.remove(sans.size() - 1);
        helper(idx+1 , sum , sans , ans , candidates , target); // taking other element the  other

    }
}
