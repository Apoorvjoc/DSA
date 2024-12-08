package BinarySearch;

public class BloomingFlower {
    public int minDays(int[] bloomDay, int m, int k) {
        int low = Integer.MAX_VALUE , high = Integer.MIN_VALUE , n = bloomDay.length , ans = -1;

        if(m*k > n)return ans;

        for(int i = 0 ; i<n ; i++){
            high = Math.max(bloomDay[i] , high);
            low = Math.min(bloomDay[i] , low);
        }

        while(low <= high){
            int mid = low + (high - low) / 2 ;
            int currBq = check(mid , bloomDay , k);
            if(currBq >= m){ // if m se jayada bhi bouquet bn jaye to no issue if (currBq == m) kiye to [10 , 10] , m = 1 , k = 1 this will fail
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    private int check(int currDay , int bloomDay[] , int k){
        int cnt = 0;
        int ans = 0;
        for(int day : bloomDay){
            if(day <= currDay){
                cnt++;
            }else{
                ans += cnt/k;
                cnt = 0;
            }
        }
        if(cnt >= k) ans += cnt/k; // check if any flower are remaining that can be placed in bouquet
        return ans;
    }
}
