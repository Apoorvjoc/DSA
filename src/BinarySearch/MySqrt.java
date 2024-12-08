package BinarySearch;

public class MySqrt {
    public int mySqrt(int x) {

        if(x == 0 || x == 1)return x;
        // this condition is handled here as java.lang.ArithmeticException: / by zero may occur while calculating mid.

        int low = 0 , high = x;
        int ans = x;
        while(low <= high){
            int mid = low + ((high - low)/2);
            if(mid <= (x/mid)){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }
}
