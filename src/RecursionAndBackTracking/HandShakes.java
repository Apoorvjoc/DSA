package RecursionAndBackTracking;

//https://www.geeksforgeeks.org/problems/handshakes1303/1
// TC : 2 ^ n
// SC : n
//At each step, the function is branching into two recursive calls, and the number of calls
// grows exponentially. Specifically, at each level of recursion,
// the size of the subproblems is halved, which gives the problem a structure similar to the Catalan number problem.
public class HandShakes {
    static int count(int N)
    {
        // code here
        return countHandshakes(N);
    }

    public static int countHandshakes(int N) {
        // Base case: If there are 0 or 2 people, only one way to arrange handshakes
        if (N == 0 || N == 2) {
            return 1;
        }

        int totalWays = 0;

        // Try pairing the first person with each other person (forward step)
        for (int i = 2; i <= N; i += 2) {
            // Count the number of ways for the remaining people in the subproblems
            totalWays += countHandshakes(i - 2) * countHandshakes(N - i);
        }

        return totalWays;
    }
}

class HandShakesCatalanNumber{
    //TODO :
}
