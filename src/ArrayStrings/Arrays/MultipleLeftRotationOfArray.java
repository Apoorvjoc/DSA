package ArrayStrings.Arrays;

/*
Problem Statement

Given an array of integers A and multiple values in B, which represents the number of times array A needs to be left rotated.
Find the rotated array for each value and return the result in a matrix where the ith row represents the rotated array for the ith value in B.
After every rotation, array A becomes equal to the original.
Example 1:
Input:
A = [1, 2, 3, 4, 5]
B = [3, 2]
Output:
[[4, 5, 1, 2, 3], [3, 4, 5, 1, 2]]
Explanation:
B[0] = 2 which requires 2 times left rotations
1: [2, 3, 4, 5, 1]
2: [3, 4, 5, 1, 2]
B[1] = 3 which requires 3 times left rotation
1: [2, 3, 4, 5, 1]
2: [3, 4, 5, 1, 2]
2: [4, 5, 1, 2, 3]
 */
public class MultipleLeftRotationOfArray {
    public int[][] multipleLeftRotation(int[] A, int[] B) {
        //You Can Code Here
        int rows = B.length;
        int cols = A.length;
        int ans[][] = new int[rows][cols];

        int copyArr[] = new int[cols];

        for(int i = 0 ; i<rows ; i++){
            int leftRotate = B[i] % cols;
            copyArr = copiedArray(A);
            // System.out.println(cols-leftRotate); right rotate concept
            rotateLeft(copyArr , ans , leftRotate , i);
        }

        return ans;
    }

    public int[] copiedArray(int A[]){
        int copyArr[] = new int[A.length];
        for(int i = 0 ; i<A.length ; i++){
            copyArr[i] = A[i];
        }
        return copyArr;
    }

    public void rotateLeft(int arr[] , int ans[][] , int k , int rowNum){
        int n = arr.length-1;
        reverse(0 , k-1 , arr);
        reverse(k , n , arr);
        reverse(0 , n , arr);

        //putting ans in arr
        for(int c = 0 ; c<=n ; c++){
            ans[rowNum][c] = arr[c];
        }
    }

    public void reverse(int s , int e , int arr[]){
        while(s<=e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
}

//left rotate approach 2:  double size array and print array from that index (pre-process approach)


/*
Approaching Right rotate question :

Ex :

arr = [1 , 2 , 3 , 4 , 5]

for leftRot = 2 ans = [3 , 4 , 5 , 1 , 2]
for rightRot = 2 ans = [4 , 5 , 1 , 2 , 3]

therefore RightRotate = (n - k) where n = size of array , k = no. of rotation
pass n-k in leftRotate function

 */

