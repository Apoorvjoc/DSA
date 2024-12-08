package ArrayStrings;

//TODO Brute force
public class PivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int lSum = 0 , rSum = 0;
        for(int i = 0 ; i<n ; i++){
            lSum = findSum(0 , i , nums);
            rSum = findSum(i , n-1 , nums);
            if(lSum == rSum)return i;
        }
        return -1;
    }

    private int findSum(int l , int r , int nums[]){
        int sum = 0;
        for(int i = l ; i<=r ; i++){
            sum += nums[i];
        }
        return sum;
    }
}

class PivotIndexOprimized {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int prefixSum[] = new int[n];
        prefixSum[0] = nums[0];

        for(int i = 1 ; i<n ; i++){
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }

        int totalSum = prefixSum[n-1];

        for(int i = 0 ; i<n ; i++){
            int lSum = prefixSum[i] - nums[i];
            int rSum = totalSum - prefixSum[i];
            if(lSum == rSum)return i;
        }

        return -1;
    }
}
