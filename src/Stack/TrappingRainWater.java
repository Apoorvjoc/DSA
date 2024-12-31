package Stack;

//TC : O(3 * n)
//SC : O(2 * n)
public class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int prevMax[] = new int[n];
        int nextMax[] = new int[n];

        prevMax[0] = height[0];
        for(int i = 1 ; i < n ; i++){
            prevMax[i] = Math.max(prevMax[i-1] , height[i]);
        }

        nextMax[n-1] = height[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            nextMax[i] = Math.max(nextMax[i+1] , height[i]);
        }

        //calculating area
        for(int i = 0 ; i<n ; i++){
            ans += Math.min(prevMax[i] , nextMax[i]) - height[i];
        }

        return ans;
    }
}

// 2 pointers
//TC : O(n)
//SC : O(1)
class TrappingRainWate_SpaceOptimized {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int prevMax[] = new int[n];
        int nextMax[] = new int[n];

        prevMax[0] = height[0];
        for(int i = 1 ; i < n ; i++){
            prevMax[i] = Math.max(prevMax[i-1] , height[i]);
        }

        nextMax[n-1] = height[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            nextMax[i] = Math.max(nextMax[i+1] , height[i]);
        }

        //calculating area
        for(int i = 0 ; i<n ; i++){
            ans += Math.min(prevMax[i] , nextMax[i]) - height[i];
        }

        return ans;
    }
}
