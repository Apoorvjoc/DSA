package RecursionAndBackTracking;

public class Fibonacci {
    public int fib(int n) {
        // 0 1 1 2 3 5 8
        // 0 1 2 3 4 5 6
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int f = 0 , s = 1 , third = 0;

        for(int i = 2 ; i<=n ; i++){
            third = f + s;
            f = s;
            s = third;
        }

        return third;
    }
}

class FibonacciRecursion {
    public int fibonacci(int n){
        if(n == 0 || n == 1) return n;

        return fibonacci(n-1) + fibonacci(n-2);
    }
}
