package BinarySearch;

// link : https://leetcode.com/problems/koko-eating-bananas/description/
/* TODO : brute  force */
public class KokoBanana {
        public int minEatingSpeed(int[] piles, int h) {
            int minHrs = -1 , n = piles.length;
            int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;

            for(int i = 0 ; i<n ; i++){
                min = Math.min(min , piles[i]);
                max = Math.max(max , piles[i]);
            }

            //taking range for number if banana
            //min can be 1 but max hm max element(in array) lenge
            for(int i = 1 ; i<=max ; i++){
                int reqTime = calcTime(piles , i);
                System.out.println("ans" + " " + reqTime);
                // System.out.println();
                if(reqTime == h)return i;
            }
            return 0;
        }

        private int calcTime(int piles[] , int currTime){
            int hours = 0;
            for(int i = 0 ; i<piles.length ; i++){
                hours += (int) Math.ceil((double)piles[i] / currTime );
                // System.out.print(" Curr ele : " + piles[i] + " time: " +currTime + " ans : " + Math.ceil(piles[i] / currTime )  + "|");
            }
            return hours;
        }
}

class KokoBananaOptimized {
    public int minEatingSpeed(int[] piles, int h) {
        int minHrs = -1 , n = piles.length;
        int min = Integer.MAX_VALUE , max = Integer.MIN_VALUE;

        for(int i = 0 ; i<n ; i++){
            min = Math.min(min , piles[i]);
            max = Math.max(max , piles[i]);
        }
        int low = 1 , high = max , ans = n;
        //taking range for number if banana
        //min can be 1 but max hm max element(in array) lenge
        while(low <= high){
            int mid = low + ((high-low)/2);
            long currTime = calcTime(piles , mid);
            System.out.println("ans" + " " + currTime);
            if(currTime <= h){
                ans = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ans;
    }

    private long calcTime(int piles[] , int currTime){
        long hours = 0;
        for(int i = 0 ; i<piles.length ; i++){
            long currHrs = (int) Math.ceil((double)piles[i] / currTime );
            hours = (hours + currHrs);
            // System.out.print(" Curr ele : " + piles[i] + " time: " +currTime + " ans : " + Math.ceil(piles[i] / currTime )  + "|");
        }
        return hours;
    }
}