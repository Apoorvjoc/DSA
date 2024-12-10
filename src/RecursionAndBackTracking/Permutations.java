package RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

// space complexity => auxilary space of o(n) of recusive stack
// T C : N! * N => N! for permutations and N for loop
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        helper(0 , new ArrayList() , ans , nums);
        return ans;
    }

    void helper(int idx, List<Integer> sans, List<List<Integer>> ans, int nums[]){
        if(idx == nums.length){
            ans.add(addAnsToLit(nums , sans));
            return;
        }

        if(idx >= nums.length)return;


        for(int i = idx ; i<nums.length ; i++){
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

class permutationUsingExtraSpace{
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        int map[] = new int[n];
        List<List<Integer>> ans = new ArrayList();

        helper(0 , nums , map , new ArrayList(), ans);

        return ans;
    }

    public void helper(int idx , int nums[] , int map[] , ArrayList<Integer> sans , List<List<Integer>> ans){

        if(sans.size() == nums.length){
            ans.add(new ArrayList(sans));
            return;
        }

        for(int i = 0 ; i<nums.length ; i++){
            if(map[i] == 0){
                sans.add(nums[i]);
                map[i] = 1;
                helper(idx ,nums , map , sans , ans);

                //backtrack
                map[i] = 0;
                sans.remove(sans.size() - 1);
            }
        }
    }
}
