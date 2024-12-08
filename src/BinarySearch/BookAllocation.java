package BinarySearch;
//https://www.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card
// NOTE : Split array and Painter partition are same

public class BookAllocation {
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length < k)return -1;

        int low = Integer.MIN_VALUE , high = 0 , ans = -1;

        for(int ele : arr){
            high += ele;
            low = Math.max(ele , low);
        }

        for(int pages = low ; pages<=high ; pages++){
            int count = booksCanBeAssigned(pages , k , arr);
            if(count <= k){
                // ans = Math.min(pages , ans);
                return pages;
            }
        }

        return ans;
    }

    private static int booksCanBeAssigned(int pages , int students , int []arr){
        int currentPages = 0 , studentCount = 1;
        int n = arr.length;
        for(int i = 0 ; i<n ; i++){
            if(currentPages + arr[i] > pages){
                currentPages = arr[i];
                studentCount++;
            }else{
                currentPages += arr[i];
            }
        }
        return studentCount;
    }
}

class BookAllocationOptimized {
    public static int findPages(int[] arr, int k) {
        // code here
        if(arr.length < k)return -1;

        int low = Integer.MIN_VALUE , high = 0 , ans = -1;

        for(int ele : arr){
            high += ele;
            low = Math.max(ele , low);
        }

        while(low <= high){
            int mid = low + (high - low) / 2 ;
            int cnt = booksCanBeAssigned(mid , arr);
            if(cnt <= k){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    private static int booksCanBeAssigned(int pages , int []arr){
        int currentPages = 0 , studentCount = 1;
        int n = arr.length;
        for(int i = 0 ; i<n ; i++){
            if(currentPages + arr[i] > pages){
                currentPages = arr[i];
                studentCount++;
            }else{
                currentPages += arr[i];
            }
        }
        return studentCount;
    }
}
