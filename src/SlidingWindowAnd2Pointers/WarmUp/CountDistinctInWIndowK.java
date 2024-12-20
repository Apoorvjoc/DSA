package SlidingWindowAnd2Pointers.WarmUp;

import java.util.ArrayList;
import java.util.HashMap;

//https://www.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class CountDistinctInWIndowK {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int l = 0 , r = 0 , n = arr.length;
        ArrayList<Integer> ans = new ArrayList();
        HashMap<Integer  , Integer> hm = new HashMap();

        while(r<n){
            int ele = arr[r];
            hm.put(ele , hm.getOrDefault(ele , 0)+1); // putting element in hashmap

            if(r - l + 1 == k){ // if any time r is at multiple of k then we are at required window
                ans.add(hm.size());
                int key = arr[l];
                hm.put(key , hm.get(key) - 1);
                if(hm.get(key) <= 0)hm.remove(key);
                l++;
            }

            r++;
        }

        return ans;
    }
}
