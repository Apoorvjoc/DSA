package RecursionAndBackTracking;

public class PredictWinner {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length-1;
        return helper(0 , n , nums , true , 0 , 0);
    }

    private boolean helper(int left , int right , int []nums , boolean playerOne , int p1Score , int p2Score){
        if(left > right){
            if(p1Score>=p2Score)return true;
            else return false;
        }

        if(playerOne){
            p1Score += nums[left];
            boolean f = helper(left + 1 , right , nums , false , p1Score , p2Score);
            p1Score -= nums[left];

            p1Score += nums[right];
            boolean s = helper(left , right - 1 , nums , false , p1Score , p2Score);
            p1Score -= nums[right];

            return f || s;
        }else{
            p2Score += nums[left];
            boolean f = helper(left + 1 , right  , nums , true , p1Score , p2Score);
            p2Score -= nums[left];

            p2Score += nums[right];
            boolean s = helper(left , right - 1 , nums , true , p1Score , p2Score);
            p2Score -= nums[right];

            return f && s; // p2 only wins if wins in both recursive call;
        }
    }
}
