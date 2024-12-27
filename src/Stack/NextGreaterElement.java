package Stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NextGreaterElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        boolean flag = false;
        for(int i = 0 ; i<n ; i++){
            flag = false;
            for(int j = i ; j<n ; j++){
                if(arr[i] < arr[j]){
                    ans.add(arr[j]);
                    flag = true;
                    break;
                }
            }
            if(!flag)ans.add(-1);
        }
        return ans;
    }
}

class nextGreater_optimal{
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> alAns = new ArrayList();
        int ans[] = new int[n];
        ans[n-1] = -1;
        Stack<Integer> st = new Stack();
        st.push(arr[n-1]);

        for(int i = n - 2 ; i>=0 ; i--){
            int ele = arr[i];
            while(!st.isEmpty() && st.peek() <= ele)st.pop();
            if(st.isEmpty()) ans[i] = -1;
            else ans[i] = st.peek();
            st.add(arr[i]);
        }

        for(int ele : ans){
            alAns.add(ele);
        }

        return alAns;
    }
}

class nextGreater_withoutSpace{
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> alAns = new ArrayList();

        alAns.add(-1);
        Stack<Integer> st = new Stack();
        st.push(arr[n-1]);

        for(int i = n - 2 ; i>=0 ; i--){
            int ele = arr[i];
            while(!st.isEmpty() && st.peek() <= ele)st.pop();
            if(st.isEmpty()) alAns.add(-1);
            else alAns.add(st.peek());
            st.add(arr[i]);
        }


        Collections.reverse(alAns);

        return alAns;
    }
}

