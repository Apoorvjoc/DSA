package BinarySearch;

public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1 , high = Integer.MIN_VALUE , ans = threshold;

        // range = 1 to max(arry)
        // min sum we can get 1 when we divide element by max ele of array or above that element
        for (int x : nums) {
            high = Math.max(high, x);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int curVal = calc(mid , nums);
            if(curVal > threshold){
                low = mid + 1;
            }else{
                ans = mid;
                high = mid - 1;
            }
        }

        return ans;
    }

    private int calc(int mid , int nums[]){
        int sum = 0;
        for(int ele : nums){
            sum += (int) Math.ceil((double) (ele/ (double) mid) );
        }
        return sum;
    }
}
