package RecursionAndBackTracking;

public class PowerOfANumber {
    public double myPow(double x, int p) {
        double ans = 1;
        long pow = p;

        if(p<0) pow = -pow;

        ans = helper(x , pow);

        if(p<0)
            ans = 1.0/ans;

        return ans;
    }

    public double helper(double x , long p){
        if(p==0) return 1;

        if(p%2 == 1){
            double smallAns = helper(x , p-1);
            return smallAns * x;
        }else{
            double smallAns = helper(x , p/2);
            return smallAns * smallAns;
        }
    }
}
