package Stack;

import java.util.Stack;

//TC : O(2n)
//sc : o(2*n) doubling array
public class NextGreaterElement2 {
    //doubling array
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int doubleArr[] = new int[2*n];

        //doubling array
        for(int i = 0 ; i<2*n ; i++){
            if(i>=n)doubleArr[i] = nums[i-n];
            else doubleArr[i] = nums[i];
        }

        int ans[] = new int[n];
        Stack<Integer> st = new Stack();
        ans[n-1] = -1;
        st.add(nums[n-1]);

        for(int i = 2*n - 1 ; i>=0 ; i--){
            int ele = doubleArr[i];

            while(!st.isEmpty() && st.peek() <= ele)st.pop();

            if(i<n){
                if(st.isEmpty()) ans[i] = -1;
                else ans[i] = st.peek();
            }

            st.add(doubleArr[i]);
        }


        return ans;
    }
}

class NextGreaterElement2_optimal{
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int ans[] = new int[n];
        Stack<Integer>st = new Stack();
        ans[n-1] = -1;
        st.add(nums[n-1]);

        for(int i = 2*n - 1 ; i>=0 ; i--){
            int idx = i%n;
            int ele = nums[idx];

            while(!st.isEmpty() && st.peek() <= ele)st.pop();

            if(i<n){
                if(st.isEmpty()) ans[i] = -1;
                else ans[i] = st.peek();
            }

            st.add(nums[idx]);
        }


        return ans;
    }
}
