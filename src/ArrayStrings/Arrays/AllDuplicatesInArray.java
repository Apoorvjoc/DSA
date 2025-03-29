package ArrayStrings.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllDuplicatesInArray {

        public List<Integer> findDuplicates_bruteforce(int[] nums) {
            HashMap<Integer , Integer> hm = new HashMap();
            List<Integer> l = new ArrayList();

            for(int ele : nums){
                hm.put(ele , hm.getOrDefault(ele , 0) + 1);
            }

            for(Map.Entry<Integer , Integer> entry : hm.entrySet()){
                if(entry.getValue() > 1)l.add(entry.getKey());
            }

            return l;
        }


    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList();

        for(int i = 0 ; i<n ; i++){
            int idx = Math.abs(nums[i])-1; // as array follows 0 based indexing and array ele are from 1 - n
            if(nums[idx] < 0) ans.add(Math.abs(nums[i])); // if idx is already visited then we found a duplicate
            else nums[idx] = -nums[idx]; // mark for visit for current element
        }

        return ans;
    }
}
