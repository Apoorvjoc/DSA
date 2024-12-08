package RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CombinationSum2 {
    //approach 1:  to add all combination generated from CombinationSum1 (with some modification) ans add in set so we get unique ans
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sorting b/c we will recieve elements as :
        //[[1,2,5],[2,6],[2,1,5],[1,7],[1,6,1],[7,1]] where [7 ,1] and [1 ,7] are same but for set it is different  ,
        // therefore if we will sort [7 ,1] and [1 ,7] will become [1 , 7] and [1 ,7] and set will treat them as sorted
        List<List<Integer>> ans = new ArrayList();
        helper(candidates , target , 0 , new ArrayList() , ans);
        //store in set to get unique
        HashSet<List<Integer>> set = new HashSet(ans);

        return new ArrayList<>(set);
    }

    public void helper(int[] candidates, int target , int idx , ArrayList<Integer> subset, List<List<Integer>> ans){
        if(target == 0) {
            ans.add(new ArrayList(subset));
            return;
        }

        if(target < 0 || idx >= candidates.length)return;

        // for(int i = idx ; i<candidates.length ; i++){
        target -= candidates[idx];
        subset.add(candidates[idx]);
        helper(candidates , target , idx + 1 , subset , ans);
        //backtrack
        target += candidates[idx];
        subset.remove(subset.size()-1);
        helper(candidates , target , idx + 1 , subset , ans);
        // }

    }
}

class CombinationSum2WithoutHashSet {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sorting b/c we will recieve elements as :
        //[[1,2,5],[2,6],[2,1,5],[1,7],[1,6,1],[7,1]] where [7 ,1] and [1 ,7] are same but for set it is different  ,
        // therefore if we will sort [7 ,1] and [1 ,7] will become [1 , 7] and [1 ,7] and set will treat them as sorted
        List<List<Integer>> ans = new ArrayList();
        helper(candidates , target , 0 , new ArrayList() , ans);
        return ans;
    }

    public void helper(int[] candidates, int target , int idx , ArrayList<Integer> subset, List<List<Integer>> ans){
        if(target == 0) {
            ans.add(new ArrayList(subset));
            return;
        }

        if(target < 0 || idx >= candidates.length)return;

        for(int i = idx ; i<candidates.length ; i++){
            if( i > idx && candidates[i] == candidates[i-1]){
                continue;
            }
            if(candidates[i] <= target) { // this if is not mandatory
                target -= candidates[i];
                subset.add(candidates[i]);
                helper(candidates, target, i + 1, subset, ans);
                //backtrack
                subset.remove(subset.size() - 1);
                target += candidates[i];
            }
        }

    }
}
