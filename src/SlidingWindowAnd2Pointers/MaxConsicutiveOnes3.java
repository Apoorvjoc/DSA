package SlidingWindowAnd2Pointers;

//https://leetcode.com/problems/max-consecutive-ones-iii/description/
//TC : n * n
//Sc : 1
public class MaxConsicutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length , ans = 0;
        for(int i = 0; i<n ; i++){
            int currK = 0;
            for(int j = i ; j<n ; j++){
                if(nums[j] == 0) currK++;
                if(currK > k)break;

                ans = Math.max(ans , j - i + 1);
            }
        }

        return ans;
    }
}

//TC : N + N (outer while + inner while)
class maxConsicutiveOneBetter{
    public int longestOnes(int[] nums, int k) {
        int n = nums.length , ans = 0;
        int l = 0 , r = 0 , currK = 0;

        while(r < n){

            if(nums[r] == 0)currK++;

            if(currK > k){
                while(nums[l] != 0)l++;
                currK--;
                l++;
            }

            int currLen = r - l + 1;
            ans = Math.max(ans , currLen);
            r++;

        }

        return ans;
    }
}

//TC : n    (in last approach tc was 2n) we reduced one extra n here
class maxConsivutiveOneOptimal{
    public int longestOnes(int[] nums, int k) {
        int n = nums.length , ans = 0;
        int l = 0 , r = 0 , currK = 0;

        while(r < n){

            if(nums[r] == 0)currK++;

            if(currK > k){
                if(nums[l] == 0)currK--;
                l++;
            }

            if(currK <= k) {
                int len = r - l + 1;
                ans = Math.max(len , ans);
            }

            r++;
        }

        return ans;
    }
}
