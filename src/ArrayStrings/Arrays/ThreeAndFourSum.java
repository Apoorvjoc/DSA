package ArrayStrings.Arrays;

import java.util.*;

public class ThreeAndFourSum {

    public static void main(String[] args) {
        int arr[] = {3 , 4 , 5 , 1 , 2};
        int sum = 6;
        List<List<Integer>> ans = TwoSum.twoSum(arr, sum);
        System.out.println("------------Two Sum-----------");
        System.out.println(ans);

        System.out.println("------------Three Sum-----------");
        int nums[] = {-1 , 0 , 1 , 2 , -1 , -4};
        System.out.println(threeSumBruteForce(nums , 0));
        /*
        with normal code o/p will be :
        ------------Three Sum-----------
            [[-1, 0, 1], [-1, 2, -1], [0, 1, -1]] we can see duplicates in array i.e -1 , 0 , 1

            After duplicate code desired o/p :
            [[-1, -1, 2], [-1, 0, 1]]
         */
    }

    public static List<List<Integer>> threeSum(int nums[] , int target){
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

        for(int i = 0 ; i<=n-3 ; i++){
            if(i > 0 && nums[i] == nums[i-1])continue; // eliminating duplicates in triplets

            int startIdx = i+1;
            target = -1 * nums[i];
            twoSums(nums , target , startIdx , triplet);
            // below code is if pair is coming from twoSum code
            //   List<List<Integer>> result = twoSums(nums , target , startIdx , triplet);
            //   for(List<Integer> list : result){
            //     list.add(0 , nums[i]);
            //     triplet.add(list);
            //   }
            //   System.out.println(triplet);
        }

        return triplet;

    }

    public static List<List<Integer>> twoSums(int nums[], int target, int startIdx, List<List<Integer>> triplet){
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
                triplet.add(Arrays.asList(-target, nums[s], nums[e])); // SYNTAX
                s++;
                e--;
            }else if(currSum < target)s++;
            else e--;
        }

        return ans;
    }

    public static List<List<Integer>> threeSumBruteForce(int nums[] , int target){
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for(int j = i+1 ; j < n ; j++){
                for (int k = j+1; k < n; k++) {
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> sAns = new ArrayList<>();
                        sAns.add(nums[i]);
                        sAns.add(nums[j]);
                        sAns.add(nums[k]);
                        Collections.sort(sAns); // eliminating duplicates
                        set.add(sAns);
                    }
                }
            }
        }

        return set.stream().toList();
    }


}
