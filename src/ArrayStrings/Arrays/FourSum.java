package ArrayStrings.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public static void main(String[] args) {
       fourSum();
    }

    public static void fourSum(){
        int nums[] = {-2 , 1 , -1 , 0 , 1 , 1 , 2 , 0};
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> quad = new ArrayList();

        for(int i = 0 ; i<=n-4 ; i++){
            if(i > 0 && nums[i] == nums[i-1])continue; // eliminating duplicates in quad

            int startIdx = i+1;
            int target = -1 * nums[i];
            // below code is if pair is coming from twoSum code
               List<List<Integer>> triplet = threeSum(nums , target , startIdx);
               for(List<Integer> list : triplet){
                 list.add(0 , nums[i]);
                 quad.add(list);
               }
//               System.out.println(triplet);
        }

        System.out.println(quad);
    }

    public static List<List<Integer>> threeSum(int nums[] , int target , int startIndex){
        // optimal approach
        /*
            we will follow 2 sum with target approach , where we need to find 2 elements from array
            such that arr[i] + arr[j] = target

            here target is our third element
            i.e

            we need to find arr[i] + arr[j] + arr[k] = 0 this can be re-written as arr[i] + arr[j] =  -1 * arr[k]
            which is similar to above condition
         */

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> triplet = new ArrayList();

        for(int i = startIndex ; i<=n-3 ; i++){
            if(i > 0 && nums[i] == nums[i-1])continue; // eliminating duplicates in triplets

            int startIdx = i+1;
            twoSums(nums , target , startIdx);

               List<List<Integer>> result = twoSums(nums , target , startIdx);
               for(List<Integer> list : result){
                 list.add(0 , nums[i]);
                 triplet.add(list);
               }
//               System.out.println(triplet);
        }

        return triplet;

    }

    // tc :  nlogn , sc = 1 ,  if we will use hashset then tc : n , sc = n
    public static List<List<Integer>> twoSums(int nums[] , int target , int startIdx){
        int s = startIdx;
        int e = nums.length-1;

        List<List<Integer>> ans = new ArrayList();

        while(s<e){
            if(s > startIdx && nums[s] == nums[s-1]){ // eliminating duplicates from left in pairs
                s++;
                continue;
            }
            if(e < nums.length-1 && nums[e] == nums[e+1]){ // eliminating duplicates from right in pairs
                e--;
                continue;
            }

            int currSum = nums[s] + nums[e];
            if(currSum == target){
                List<Integer> sAns = new ArrayList();
                sAns.add(nums[s]);
                sAns.add(nums[e]);
                ans.add(new ArrayList<>(sAns));
                s++;
                e--;
            }else if(currSum < target)s++;
            else e--;
        }

        return ans;
    }

}


//[[-2, 0, 1, 1], [-2, 0, 2, 0], [-1, 0, 1, 0]]