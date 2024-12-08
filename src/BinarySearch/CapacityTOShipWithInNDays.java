package BinarySearch;

public class CapacityTOShipWithInNDays {
    public int shipWithinDays(int[] weights, int days) {
        // low = max element of array as hmko capacity min itti to leni padegi jisse ki ship hmare saman ka load utha paye
        // high = sum of all element of array (sum of all element se jayada kabhi hmko store hi nhi krna padega)

        int low = weights[0] , high = 0 , ans = -1;

        for(int x : weights){
            high += x;
            low = Math.max(x , low);
        }

        while(low <= high){
            int capacity = low + (high - low) / 2;
            int currDays = valid(capacity , weights);
            if(currDays <= days){
                ans = capacity;
                high = capacity - 1;
            }else{
                low = capacity + 1;
            }
        }

        return ans;

    }

    private int valid(int currCapacity , int []weights){
        int load = 0;
        int days = 1;
        for(int weight : weights){
            if(load + weight > currCapacity){
                days++;
                load = 0;
                load += weight;
            }else{
                load += weight;
            }
        }
        return days;
    }
}
