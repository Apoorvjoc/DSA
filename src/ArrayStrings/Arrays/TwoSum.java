package ArrayStrings.Arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//If it is asked pair in ans should be in sorted fashion then initial array should be sorted
// similar in 3 sum

//TC : o(nlogn)
public class TwoSum {

    public static void main(String[] args) {
        int arr[] = {3 , 4 , 5 , 1 , 2};
        int sum = 6;
        List<List<Integer>> ans = twoSum(arr, sum);
        List<List<Integer>> bans = bruteforce(arr, sum);

        System.out.println(ans);
        System.out.println("Brute force ans " + bans);

    }

    public static List<List<Integer>> twoSum(int arr[], int sum){
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        int s = 0 , e = arr.length-1;

        while (s<e){ // if <= is present then ans will be [[1, 5], [2, 4] , [3,3]] , for current condition ans will be [[1, 5], [2, 4]]
            int currSum = arr[s] + arr[e];

            if(sum == currSum){
                List<Integer> sAns = new ArrayList<>();
                sAns.add(arr[s]);
                sAns.add(arr[e]);
                ans.add(new ArrayList<>(sAns));
                s++;
                e--;
            }else if(currSum < sum){
                s++;
            }else{
                e--;
            }

        }
        return ans;
    }

    public static List<List<Integer>> bruteforce(int nums[] , int target){
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    List<Integer> sAns = new ArrayList<>();
                    sAns.add(nums[i]);
                    sAns.add(nums[j]);
                    ans.add(new ArrayList<>(sAns));
                }
            }
        }
        return ans;
    }
}
