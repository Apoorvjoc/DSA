package Stack;

import java.util.Stack;

//https://leetcode.com/problems/largest-rectangle-in-histogram/
// tc : o (n*n)
public class LargestAreaUnderHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int min;
        int ans = 0;
        for(int i = 0 ; i<n ; i++){
            min = heights[i];
            for(int j = i ; j<n ; j++){
                min = Math.min(min , heights[j]);
                int width = j - i + 1;
                int height = min;
                ans = Math.max(ans , height * width);
            }
        }
        return ans;
    }
}

//TC : O(5*N)
//SC : O(2*N) + O(N) FOR ANS ARRAY
class LargestAreaUnderHistogram_optimal {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        //we will store index in these so that we can find width of area.
        int lse[] = new int[n]; // next smallest element to left
        int rse[] = new int[n]; // next smallest element to right

        lse = prevSmallest(heights , n);
        rse = nextSmallest(heights , n);

        //finding area;

        for(int i = 0 ; i<n ; i++){
            int width = rse[i] - lse[i]-1;
            int height = heights[i];
            ans = Math.max(ans , width * height);
        }

        return ans;
    }

    private int[] prevSmallest(int heights[] , int n){
        int lse[] = new int[n];
        Stack<Integer> stl = new Stack();
        stl.add(0);
        lse[0] = -1;

        for(int i = 1 ; i<n ; i++){
            int ele = heights[i];
            while( !stl.isEmpty() && heights[stl.peek()] >= ele){
                stl.pop();
            }
            if(stl.isEmpty())lse[i] = -1;
            else lse[i] = stl.peek();

            stl.add(i);
        }
        return lse;
    }

    private int[] nextSmallest(int heights[] , int n){
        int rse[] = new int[n];
        Stack<Integer>str = new Stack();
        str.add(n-1);
        rse[n-1] = n;

        for(int i = n - 2 ; i>=0 ; i--){
            int ele = heights[i];
            while( !str.isEmpty() && heights[str.peek()] >= ele){
                str.pop();
            }
            if(str.isEmpty())rse[i] = n;
            else rse[i] = str.peek();

            str.add(i);
        }

        return rse;
    }
}

class mostOptimal{

}
