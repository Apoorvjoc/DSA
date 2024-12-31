package Queues;

import java.util.ArrayDeque;

//TC : O(n - k) * k
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[]=new int[nums.length-k+1];
        int z = 0 , n = nums.length;

        for(int i = 0 ; i<=n-k ; i++){
            int minele = nums[i];
            for(int j = i ; j<=i+k-1 ; j++){
                minele = Math.max(minele , nums[j]);
            }
            res[z++] = minele;
        }

        return res;
    }
}

class SlidingWindowMaximum_Optimal {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length , x = 0;
        int res[]=new int[n-k+1];

        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i = 0 ; i<n ; i++){

            //check for if we are at valid index
            if(!dq.isEmpty() &&  dq.peekFirst() + k <= i){ // ex : dq = [2 , 3 , 4] if k = 3 , i = 0 , then 2 + 3 < 0 currIdx
                dq.removeFirst();
            }

            //removing smaller element from queue which are smaller than current
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.removeLast();
            }

            dq.add(i);

            if(i>=k-1)res[x++] = nums[dq.peekFirst()];

        }

        return res;
    }
}
