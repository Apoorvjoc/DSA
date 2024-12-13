package SlidingWindowAnd2Pointers;

import java.util.Arrays;
import java.util.HashMap;

//TC : nlogn
//SC : 1
public class TwoSumPairGFG {
    boolean twoSum(int arr[], int target) {
        // code here
        Arrays.sort(arr);

        int s = 0 , e = arr.length-1;

        while(s<=e){
            int sum = arr[s] + arr[e];
            if(sum == target)return true;
            else if (sum<target) s++;
            else e--;
        }

        return false;
    }
}
//tc : n
//sc : n
class TwoSumPairGFGOptimal {
    boolean twoSum(int arr[], int target) {
        // code here
        HashMap<Integer , Integer> hm = new HashMap();

        for(int ele : arr){
            int reqSum = target - ele;
            if(hm.containsKey(reqSum)){
                return true;
            }else{
                hm.put(ele , 1);
            }
        }

        return false;
    }
}
