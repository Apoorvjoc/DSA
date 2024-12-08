package ArrayStrings;

//https://practice.geeksforgeeks.org/problems/minimum-swaps-required-to-bring-all-elements-less-than-or-equal-to-k-together/0

// following code will not work if elements are already in decreasing order of sorting like [5 , 4 , 3 , 2 , 1] and k = 3
/*
In above example ans will be 0 as all elements are at right side of k and are smaller than 3
but below code will give ans as 2

By the way this testcase is not present in gfg so this is submitted

correct code is given at class MinSwapsCorrect
 */

public class MinSwaps {
    int minSwap(int[] arr, int k) {
        // Complete the function
        int l = 0 , r = arr.length-1;
        int cnt = 0;
        while(l<r){
            if(arr[l] <= k){
                l++;
            }
            else if(arr[r] > k){
                r--;
            }else{
                //swap
                int temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
                cnt++;
            }
        }

        return cnt;
    }
}

class MinSwapsCorrect {
    // Function for finding maximum and value pair
    int minSwap(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Count how many elements are less than or equal to k
        int count_k = 0;
        for (int num : arr) {
            if (num <= k) {
                count_k++;
            }
        }

        // Step 2: Find the maximum number of elements ≤ k in any subarray of size count_k
        int badCount = 0; // number of elements > k in the current window
        // Initialize the first window
        for (int i = 0; i < count_k; i++) {
            if (arr[i] > k) {
                badCount++;
            }
        }

        // Now slide the window and track the minimum number of bad elements
        int minBadCount = badCount;
        for (int i = count_k; i < n; i++) {
            // Slide the window to the right: remove the leftmost element and add the new one
            if (arr[i - count_k] > k) {
                badCount--; // The element we remove is greater than k
            }
            if (arr[i] > k) {
                badCount++; // The new element we add is greater than k
            }
            // Update the minimum bad count
            minBadCount = Math.min(minBadCount, badCount);
        }

        // The result is the minimum bad count
        return minBadCount;
    }
}

/*
Algorithm
Count the number of elements ≤ k (let's call it count_k).
Initialize a sliding window of size count_k and calculate the number of "bad" elements (i.e., elements greater than k) within that window.
Slide the window across the array and track the minimum number of "bad" elements.
The answer is the minimum "bad" count, as this represents the minimum number of swaps required.

Explanation of the Code:
Counting Elements ≤ k:

We first count the number of elements in the array that are less than or equal to k and store this value in count_k.
Sliding Window:

We initialize the sliding window by counting how many elements in the first window of size count_k are greater than k (i.e., "bad" elements).
Then, we slide the window one element at a time. For each step:
We remove the element that's going out of the window and check if it's greater than k (if yes, decrement the badCount).
We add the new element coming into the window and check if it's greater than k (if yes, increment the badCount).
At each step, we keep track of the minimum number of "bad" elements in any window of size count_k.
Result:

The minimum badCount is the answer because it represents the minimum number of elements that are greater than k in a window of size count_k, which is the minimum number of swaps needed.
Example Walkthrough
For the input arr[] = [2, 1, 5, 6, 3] and k = 3:

Count elements ≤ k:

Elements ≤ 3 are: [2, 1, 3]. So, count_k = 3.
Sliding window of size 3:

First window: [2, 1, 5] → badCount = 1 (only 5 is greater than 3).
Second window: [1, 5, 6] → badCount = 2 (both 5 and 6 are greater than 3).
Third window: [5, 6, 3] → badCount = 2 (both 5 and 6 are greater than 3).
Minimum bad count = 1.

Thus, the minimum number of swaps required is 1.


 */
