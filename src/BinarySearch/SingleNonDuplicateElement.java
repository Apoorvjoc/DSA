package BinarySearch;

public class SingleNonDuplicateElement {
    public int singleNonDuplicate(int[] nums) {
        int ans = -1 , n = nums.length;
        //base condition
        if( (n==1) || (nums[0]!=nums[1])){
            return nums[0];
        }
        if(nums[n-1] != nums[n-2])return nums[n-1];

        int low = 1 , high = n-2;

        while(low <= high){
            int mid = (low + high)/2;

            if( (nums[mid] != nums[mid-1]) && (nums[mid] != nums[mid+1]) )return nums[mid];
            else if(
                    (mid%2 == 0) && (nums[mid] == nums[mid+1]) || // check for even idx for mid
                            (mid%2 == 1) && (nums[mid-1] == nums[mid]) // check for odd idx for mid
            ) {//move to right half eliminate left half
                low = mid + 1;
            }else{//move to left half eliminate right half
                high = mid - 1;
            }
        }

        return ans;
    }
}
