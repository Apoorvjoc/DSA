package RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/powet-set-lexicographic-order/
// TC : o((2 ^ n) * n)  and SC : o((2 ^ n) * n)
//for SC :
// 2 ^ n is the number of subsets we store.
// n is the maximum length of any subset.
public class SubSetInSortedOrder {
    public List<List<Integer>> subset(int[] candidates) {
        List<List<Integer>>  ans = new ArrayList();
        helper(0 , ans , new ArrayList() , candidates);
        return ans;
    }

    private void helper(int idx ,  List<List<Integer>>  ans , List<Integer> sans , int[] candidates){
        ans.add(new ArrayList(sans));

        for(int i = idx ; i<candidates.length ; i++){

            if (i > idx && candidates[i] == candidates[i - 1]) { // find duplicates
                continue;
            }

            sans.add(candidates[i]);
            helper(i+1 , ans , sans , candidates);
            //backtrack
            sans.remove(sans.size() - 1);
        }
    }
}

class SubSetInSortedOrderUsingBitMasking {
    public List<List<Integer>> subset(int[] candidates) {
        List<List<Integer>> ans = new ArrayList();
        helper(0, ans, new ArrayList(), candidates);
        return ans;
    }

    private void helper(int idx, List<List<Integer>> ans, List<Integer> sans, int[] candidates) {
        ans.add(new ArrayList(sans));

        for (int i = idx; i < candidates.length; i++) {

            if (i > idx && candidates[i] == candidates[i - 1]) { // find duplicates
                continue;
            }

            sans.add(candidates[i]);
            helper(i + 1, ans, sans, candidates);
            //backtrack
            sans.remove(sans.size() - 1);
        }
    }
}