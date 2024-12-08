package Sorting;

/*
Points:

P1: (-1, 5)
P2: (1, 6)
P3: (3, 5)
P4: (2, 3)
Calculating Pairwise Manhattan Distances:

P1 and P2:

|(-1) - 1| + |5 - 6| = 3
P1 and P3:

|(-1) - 3| + |5 - 5| = 4
P1 and P4:

|(-1) - 2| + |5 - 3| = 5
P2 and P3:

|1 - 3| + |6 - 5| = 3
P2 and P4:

|1 - 2| + |6 - 3| = 4
P3 and P4:

|3 - 2| + |5 - 3| = 3
Summing the Distances:

Total Manhattan Distance = 3 + 4 + 5 + 3 + 4 + 3 = 22

Therefore, the total Manhattan distance between all pairs of the given points is 22.
 */

public class ManhattanDistances {

    static int distancesum(int x[], int y[], int n)
    {
        int sum = 0;

        // for each point, finding distance to
        // rest of the point
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                sum += (Math.abs(x[i] - x[j])
                        + Math.abs(y[i] - y[j]));
        return sum;
    }

    // Driven Program
    public static void main(String[] args)
    {
        int x[] = { -1, 1, 3, 2 };
        int y[] = { 5, 6, 5, 3 };
        int n = x.length;

        System.out.println(distancesum(x, y, n));
    }


    class ManhattanDistanceOptimized {
        public static int totalManhattanDistance(int[][] points) {
            int n = points.length;
            int[] prefixXSum = new int[n];
            int[] prefixYSum = new int[n];

            int xSum = 0, ySum = 0;
            for (int i = 0; i < n; i++) {
                xSum += points[i][0];
                ySum += points[i][1];
                prefixXSum[i] = xSum;
                prefixYSum[i] = ySum;
            }

            int totalDistance = 0;
            for (int i = 0; i < n; i++) { // TODO : Dry run  this
                totalDistance += (n - i - 1) * points[i][0] - prefixXSum[i] + prefixXSum[n - 1] - prefixXSum[i];
                totalDistance += (n - i - 1) * points[i][1] - prefixYSum[i] + prefixYSum[n - 1] - prefixYSum[i];
            }

            return totalDistance;
        }

        public static void main(String[] args) {
            int[][] points = {{-1, 5}, {1, 6}, {3, 5}, {2, 3}};
            int result = totalManhattanDistance(points);
            System.out.println(result); // Output: 22
        }
    }

}
