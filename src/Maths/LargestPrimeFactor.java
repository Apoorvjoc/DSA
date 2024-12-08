package Maths;

public class LargestPrimeFactor {
    static long largestPrimeFactor(int N) {
        // code here
        long ans = Long.MIN_VALUE;
        for(int i = 2 ; i*i<=N ; i++){

            ans = Math.max(ans , i);

            if((N%i) == 0){
                while((N%i) == 0){
                    N = N / i;
                }
            }
        }

        return N > 1 ? N : ans;
    }
}
