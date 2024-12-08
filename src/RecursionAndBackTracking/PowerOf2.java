package RecursionAndBackTracking;

//https://leetcode.com/problems/power-of-two


//Approach
//If n is divisible by 2 , every time we will encounter 1 at the end.
//And at any point if n isn't divisible by 2 we will return false.
//TC : o(log number)
public class PowerOf2 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;

        while (n > 0) {
            if (n == 1) return true;
            if (n % 2 != 0) break;
            n /= 2;
        }
        return false;
    }
}

//Approach
//And operation between multiple of 2 and next lower number will always give 0 and other wise it will never be 0.
//example 1: 8 & 7
//        1000(8) & 0111(7) => 0000(0) TODO : for highlighting purpose in Intellij
//
//example 1: = 10 & 9
//        1010(10) & 1001(9) => 1000(8)
//TC : o(1)
class PowerOf2Approach2{
    public boolean isPowerOfTwo(int n) {
        return (n > 0) && ((n & (n - 1)) == 0);
    }
}
