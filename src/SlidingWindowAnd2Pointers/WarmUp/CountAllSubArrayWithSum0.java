package SlidingWindowAnd2Pointers.WarmUp;

import java.util.HashMap;

public class CountAllSubArrayWithSum0 {
    //brute force
    public int findSubarray(int[] arr) {
        // code here.
        int n = arr.length;
        int cnt = 0;

        for(int i = 0 ; i<n ; i++){
            int sum = 0;
            for(int j = i ; j<n ; j++){
                sum+=arr[j];
                if(sum == 0)cnt++;
            }
        }

        return cnt;
    }
}

// unlike previous problems we are taking cnt instead of index
// if sum already exists then we will cnt++
class CountAllSubArrayWithSum0_Optimal {
    public int findSubarray(int[] arr) {
        // code here.
        int n = arr.length;
        int cnt = 0 , sum = 0;
        HashMap<Integer , Integer> hm = new HashMap();
        hm.put(0 , 1);

        for(int i = 0 ; i<n ; i++){
            sum+=arr[i];

            if(hm.containsKey(sum)){
                cnt += hm.get(sum);
                hm.put(sum , hm.get(sum) + 1);
            }else{
                hm.put(sum , 1);
            }
        }

        return cnt;
    }
}
