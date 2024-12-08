package ArrayStrings;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;

        for(int i = n - 2 ; i>=0 ; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }

        //still value of idx == -1 means given element was last therefore reverse (for array of 1 2 3 => you have to find next permutation of 321 it will be 123)
        // as 3 2 1 (i.e all i th ele are greater than i+1 th ele)

        if(idx == -1){ // edge case
            reverse(nums , 0 , n-1);
            return;
        }

        // from last find least greater
        for(int i = n - 1 ; i>idx ; i--){
            if(nums[i] > nums[idx]){
                // swap
                int t = nums[i];
                nums[i] = nums[idx];
                nums[idx] = t;
                break;
            }
        }

        //reverse
        reverse(nums , idx+1 , n-1);

    }

    private void reverse(int arr[] , int s , int e){

        while(s <= e){
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            s++ ; e--;
        }
    }
}
