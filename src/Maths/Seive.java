package Maths;

import java.util.Arrays;

public class Seive {
    public long prime_Sum(int n)
    {
        // code here
        int seive[] = new int[n+1];
        Arrays.fill(seive , 1);

        long sum = 0;

        findSeive(seive , n);

        for(int i = 0 ; i<=n ; i++){
            if(seive[i] == 1)sum+=i;
        }

        return sum;
    }

    private void findSeive(int seive[] , int n){

        seive[0] = 0;
        seive[1] = 0;

        for(int i = 2 ; i*i<=n ; i++){
            for(int j = i*i ; j<=n ; j+=i){
                seive[j] = 0;
            }
        }
    }
}
