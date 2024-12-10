package RecursionAndBackTracking;

import java.util.*;

public class Permutation2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);

        //using permutation 1 and putting it in hashmap
        Permutations p = new Permutations();
        p.helper(0 , new ArrayList<>(), ans , nums);
        HashSet<List<Integer>> l = new HashSet(ans);
        return new ArrayList(l);
    }
}

class PermOptimized{
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        helper(0 , new ArrayList() , ans , nums);
        return ans;
    }

    private void helper(int idx , List<Integer>sans , List<List<Integer>> ans , int nums[]){
        if(idx == nums.length){
            ans.add(addAnsToLit(nums , sans));
            return;
        }

        if(idx >= nums.length)return;

        Set<Integer> s = new HashSet();

        for(int i = idx ; i<nums.length ; i++){

            //duplicate handle multiple occ of element
            if(s.contains(nums[i])) continue;

            s.add(nums[i]);

            swap(idx , i , nums);
            helper(idx + 1 , sans , ans , nums);
            //backtrack
            swap(idx , i , nums);
        }
    }

    private List<Integer> addAnsToLit(int nums[] , List<Integer> sans){
        List<Integer> l = new ArrayList();

        for(int i = 0 ; i<nums.length ; i++){
            l.add(nums[i]);
        }

        return l;
    }

    private void swap(int idx , int i , int nums[]){
        int temp = nums[idx];
        nums[idx] = nums[i];
        nums[i] = temp;
    }
}


