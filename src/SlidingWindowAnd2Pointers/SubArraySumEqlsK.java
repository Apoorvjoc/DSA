package SlidingWindowAnd2Pointers;

import java.util.HashMap;

public class SubArraySumEqlsK {
    public static void main(String[] args) {
        int arr[] = {3 , 9 , -2 , 4 , 1 , -7 , 2 , 6 , -5 , 8 , - 3 , - 7 , 6 , 2 ,1};
        int arr2[] = {2 , 6 , -2 , 3 , 3, 0 , 1, 2 , 3}; // for k = 6
        System.out.println(countSubArraySumEqualsk(arr2 , 6));
//        System.out.println(countSubArraySumEqualsk(arr , 5));
    }

    private static int countSubArraySumEqualsk(int arr[], int k){
        int ans = 0 , n = arr.length , sum = 0;

        for(int i = 0 ; i<n ; i++){
            sum = 0;
            for(int j = i ; j<n ; j++){
                sum+=arr[j];
                if(sum == k)ans++;
            }
        }

        return ans;
    }
}

class SubArraySumEqlsK_optimal {
    public static void main(String[] args) {
        int arr[] = {3 , 9 , -2 , 4 , 1 , -7 , 2 , 6 , -5 , 8 , - 3 , - 7 , 6 , 2 ,1}; // for k = 5 ans = 7
        int arr2[] = {2 , 6 , -2 , 3 , 3, 0 , 1, 2 , 3}; // for k = 6 ans = 7
        System.out.println(countSubArraySumEqualsk(arr2 , 6));
    }

    private static int countSubArraySumEqualsk(int arr[], int k){
        int ans = 0 , n = arr.length , sum = 0;
        HashMap<Integer , Integer> hm = new HashMap<>(); // hashmap to store sum and its freq (how many times sum has occurred)

        hm.put(0 , 1);

        for(int i = 0 ; i<n ; i++){
            sum += arr[i];
            int target = sum - k;

            if(hm.containsKey(target)){
                ans += hm.get(target);
            }

            hm.put(sum , hm.getOrDefault(sum , 0) + 1);

        }

        return ans;
    }
}
