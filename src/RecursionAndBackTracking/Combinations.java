package RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/combinations/
// Approach : check and uncheck (2 opt)
// TC : O (nCk) ==>  and SC : O (nCk) ==> C(n,k)[for combination]×O(k)[for data copying from sans to ans] we are storing all combinations ==> Space Complexity=O(C(n,k)×k)+O(k) = O(C(n,k)×k)

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> sans = new ArrayList();
        int nums[] = new int[n];

        for(int i = 0 ; i<n ; i++){
            nums[i] = i+1;
        }

        helper(0 , sans , ans , nums ,  n , k);
        return ans;
    }

    private void helper(int idx , List<Integer> sans , List<List<Integer>> ans , int nums[] , int n , int k){
        //base conditions
        if(sans.size() == k){
            ans.add(new ArrayList(sans));
            return;
        }

        if(idx >= n)return;

        sans.add(nums[idx]);
        helper(idx + 1 , sans , ans , nums , n , k);

        //backtrack
        sans.remove(sans.size() - 1);
        helper(idx + 1 , sans , ans , nums , n , k);

    }
}

//approach : n opt (for loop)
// TC : O (nCk) ==>  and SC : O (nCk) ==> C(n,k)[for combination]×O(k)[for data copying from sans to ans] we are storing all combinations ==> Space Complexity=O(C(n,k)×k)+O(k) = O(C(n,k)×k)
class CombinationsApproach2 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> sans = new ArrayList();
        helper(n , k , ans , sans , 1);
        return ans;
    }

    public void helper(int n , int k ,  List<List<Integer>> ans ,  List<Integer> subset , int start){
        if(subset.size() == k){
            ans.add(new ArrayList<>(subset));
            return;
        }

        for(int i = start ; i<=n ; i++){
            subset.add(i);
            helper(n , k , ans , subset , i+1);
            subset.remove(subset.size() - 1);
        }

    }
}
