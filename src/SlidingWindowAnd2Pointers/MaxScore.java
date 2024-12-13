package SlidingWindowAnd2Pointers;

//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
//TC : n or 2 * K
public class MaxScore {
    public int maxScore(int[] cardPoints, int k) {
        int sumk = 0 , n = cardPoints.length;

        // calculate sum of k elements
        for(int i = 0 ; i<k ; i++){
            sumk+=cardPoints[i];
        }

        int s = k-1 , e = n-1  , ans = sumk;

        //remove element from front and add from last
        for(int i = 0 ; i<k ; i++){
            sumk-=cardPoints[s--]; // remove from start
            sumk+=cardPoints[e--]; // adding from end
            ans = Math.max(sumk , ans); // find max
        }

        return ans;
    }
}
