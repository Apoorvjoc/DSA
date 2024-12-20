package SlidingWindowAnd2Pointers;

import java.util.HashMap;

//https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
public class ArrayPairsDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer , Integer> hm = new HashMap();

        for(int ele : arr){
            int rem = (ele % k + k) % k; //guarantees that the remainder is always a non-negative integer in the range [0, k-1], regardless of whether ele is positive or negative.
            hm.put(rem , hm.getOrDefault(rem , 0) + 1);
        }

        for(int rem : hm.keySet()){
            //int rem = (ele % k + k) % k;
            int freq = hm.get(rem);
            int freqk = hm.getOrDefault(k - rem , 0); // used getOrDefault as (k - rem) may exists or may not in map
            if(rem == 0){
                if(freq % 2 == 1)return false;
            }
            else if(2*rem == k){  // equivalent to freq = k/2
                if(freq % 2 == 1)return false;
            }else{
                if(freq != freqk)return false;
            }
        }

        return true;
    }
}

/*
Example:
Let's look at a few examples using k = 14:

When ele = -10:
ele % k = -10 % 14 = -10 (negative remainder)
(ele % k + k) = -10 + 14 = 4
(ele % k + k) % k = 4 % 14 = 4

When ele = 5:
ele % k = 5 % 14 = 5 (positive remainder)
(ele % k + k) = 5 + 14 = 19
(ele % k + k) % k = 19 % 14 = 5

When ele = 0:
ele % k = 0 % 14 = 0 (remainder is already 0)
(ele % k + k) = 0 + 14 = 14
(ele % k + k) % k = 14 % 14 = 0
*/

