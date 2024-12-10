package RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList();
        int arr[] = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8, 9};

        int sum = 0;
        for(int i = 1 ; i <= k ; i++){
            sum += i;
        }

        if(sum > n) return ans;

        helper(0 , k , n , arr , new ArrayList() , ans);

        return ans;
    }

    public void helper(int idx , int k, int target , int arr[] , List<Integer>subset , List<List<Integer>> ans){
        if(target == 0 && subset.size() == k){
            ans.add(new ArrayList(subset));
            return;
        }

        if(idx >= arr.length && target < 0)return;

        for(int i = idx ; i<arr.length ; i++){
            if(target < arr[i]) break;

            subset.add(arr[i]);
            target -= arr[i];
            helper(i + 1 , k , target , arr , subset , ans);
            target += arr[i];
            subset.remove(subset.size() - 1);

        }

    }
}
