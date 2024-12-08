package BinarySearch;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/aggressive-cows/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
public class AgressiveCows_BruteForce {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length , ans = -1;

        Arrays.sort(stalls);

        int max = stalls[n-1];

        //maximum range can be max element of array b/c 1st cow agr oth idx me hai to next cow can be at max of last idx
        //last idx se jayada bhi rkh skte hai but it is of no use but ans usse bhi aa skta hai
        for(int distance = 1 ; distance<=max ; distance++){
            boolean isValid = allCowsCanBePlaced(distance , k , stalls);
            if(isValid){
                ans = Math.max(distance , ans);
            }
        }

        return ans;
    }

    private static boolean allCowsCanBePlaced(int distance , int cows , int []stalls){
        int lastCow = stalls[0];
        int cowsPlacedTillNow = 1; // 1st cow is placed at index 0 in above line

        for(int i = 1 ; i<stalls.length ; i++){
            if(stalls[i] - lastCow >= distance){
                cowsPlacedTillNow++;
                lastCow = stalls[i];
            }
            if(cows == cowsPlacedTillNow)return true;
        }

        return false;
    }
}

class AgressiveCows_Optimal {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        int n = stalls.length , ans = 0;

        Arrays.sort(stalls);

        int max = stalls[n-1];

        int low = 1 , high = max;

        //maximum range can be max element of array b/c 1st cow agr oth idx me hai to next cow can be at max of last idx
        //last idx se jayada bhi rkh skte hai but it is of no use but ans usse bhi aa skta hai
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(allCowsCanBePlaced(mid,k,stalls)){
                ans = Math.max(ans , mid);
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return ans;
    }

    private static boolean allCowsCanBePlaced(int distance , int cows , int []stalls){
        int lastCow = stalls[0];
        int cowsPlacedTillNow = 1; // 1st cow is placed at index 0 in above line

        for(int i = 1 ; i<stalls.length ; i++){
            if(stalls[i] - lastCow >= distance){
                cowsPlacedTillNow++;
                lastCow = stalls[i];
            }
            if(cows == cowsPlacedTillNow)return true;
        }

        return false;
    }
}
