package BinarySearch;

//link : https://www.geeksforgeeks.org/problems/find-nth-root-of-m5843/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class NthRootOfM {
    public int nthRoot(int n, int m) {
        // code here
        int low = 0 , high = m;

        while(low <= high){
            int mid = low + ((high - low)/2);
            int pow = func(mid , n , m);
            if(pow == 1){
                return mid;
            }else if(pow == 0){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public int func(int number , int n , int reqAns){
        long ans = 1;
        for(int i = 1 ; i<=n ; i++){
            ans *= number;
            if(ans > reqAns) {
                return -1;
            }
        }
        return ans == reqAns ? 1 : 0;
    }
}
