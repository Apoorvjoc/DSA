package SlidingWindowAnd2Pointers;

import java.util.HashMap;
import java.util.HashSet;

//https://www.geeksforgeeks.org/problems/equivalent-sub-arrays3731/0

public class EquivalentSubArray {
    static int countDistinctSubarray(int arr[], int n)
{
    HashSet<Integer> set = new HashSet();
    HashMap<Integer , Integer> hm = new HashMap();

    for(int x : arr){
        set.add(x);
    }

    //making problem like count subarrays with k distinct elements
    int k = set.size();

    int l = 0 , r = 0 , ans = 0;

    while(r<n){
        int ele = arr[r];

        hm.put(ele , hm.getOrDefault(ele , 0) + 1);

        while(hm.size() == k){
            int lele = arr[l];
            ans += (n - r); // thing to note here this
            /*
                if any point of time we get all required elements then possible sub arrays will be n - r
                ex : [2, 1, 3, 2, 3]
                at idx = 2 i.e arr[2] we get all distinct element of array then all subarray formed with 2 1 3 ,
                all subarrays after idx 2  will always contain required element(2 1 3 )
                therefore following 3 subarrays are possible by formula n - r
                2, 1, 3
                2, 1, 3 , 2
                2, 1, 3 , 2 ,3

                similarly for 1 3 2 , 2 subarrays are possible
                1 3 2
                1 3 2 3

            */
            hm.put(lele , hm.get(lele)-1);
            if(hm.get(lele) == 0)hm.remove(lele);
            l++;
        }

        r++;
    }

    return ans;
}
}
