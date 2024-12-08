package Maths;

public class PowerExponentiation {
    public double myPow(double num, int p) {
        double n = num;
        long pow = p;
        if(p < 0) pow = -pow;
        double ans = 1;

        while(pow > 0){
            if(pow % 2 == 0){
                num = num * num;
                pow = pow / 2;
            }else{
                ans = ans * num;
                pow = pow - 1;
            }
        }

        if(p < 0){
            ans = 1.0 / ans;
        }

        return ans;
    }
}

class PowerExponentiationRecursive {
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
