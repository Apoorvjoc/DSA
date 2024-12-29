package Stack;

import java.util.Stack;

public class SumOfSubArrayMin {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length ;
        long sum = 0;
        int MOD = 1000000007;

        int prev[] = prevSmallest(arr);
        int next[] = nextSmallest(arr);

        for(int i = 0 ; i<n ; i++){
            long elementAtLeft = i - prev[i];
            long elementAtRight = next[i] - i;
            long totalCountCurrentElementCanComeInSubarray = (elementAtLeft * elementAtRight) % MOD;

            // if koi element 10 bar ayega to usme sum 10 bar add krna padega
            // if element = 3 then 3 + 3 + 3 + ..... 10 times
            // above line can be written as arr[i] * totalCountCurrentElementCanComeInSubarray
            long totalContributionOfCurrentElement = arr[i] * (totalCountCurrentElementCanComeInSubarray) % MOD;

            sum = (sum + totalContributionOfCurrentElement) % MOD;
        }

        return (int)sum;
    }

    private int[] prevSmallest(int []arr){
        int n = arr.length;
        Stack<Integer> st = new Stack();
        int prev[] = new int[n];

        for(int i = 0 ; i<n ; i++){
            int ele = arr[i];

            while(!st.isEmpty() && arr[st.peek()] >= ele)st.pop();

            if(st.isEmpty())prev[i] = -1;
            else prev[i] = st.peek();

            st.add(i);
        }

        return prev;
    }

    private int[] nextSmallest(int []arr){
        int n = arr.length;
        Stack<Integer>st = new Stack();
        int next[] = new int[n];

        for(int i = n-1 ; i>=0 ; i--){
            int ele = arr[i];

            while(!st.isEmpty() && arr[st.peek()] > ele)st.pop();

            if(st.isEmpty())next[i] = n;
            else next[i] = st.peek();

            st.add(i);
        }

        return next;
    }
}

class SumOfSubArrayMin_BruteForce {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length , sum = 0;
        int MOD = (int)1e9 + 7;

        for(int i = 0 ; i<n ; i++){
            int minEle = arr[i];
            for(int j = i ; j<n ; j++){
                minEle = Math.min(minEle , arr[j]);
                sum = (sum + minEle) % MOD;
            }
        }

        return sum;
    }
}