package BinarySearch;

public class MedainOfArray {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length , m = nums2.length;
        int o = m+n;
        int nums3[] = new int [o];

        int i = 0 , j = 0 , k = 0;

        while(i<n && j<m){
            if(nums1[i] < nums2[j]){
                nums3[k++] = nums1[i++];
            }else{
                nums3[k++] = nums2[j++];
            }
        }

        while(i<n){
            nums3[k++] = nums1[i++];
        }

        while(j<m){
            nums3[k++] = nums2[j++];
        }

        if(nums3.length%2 == 1)return nums3[o/2];
        else{
            double nby2 = (double)nums3[o/2];
            double nby2Plus1 = (double)nums3[(o/2)-1];
            System.out.println(nby2+" and "+nby2Plus1);
            return (nby2+nby2Plus1)/2;
        }
    }
}

class MedainOfArraySpaceOptomized {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length , n2 = nums2.length , n = (n1 + n2);
        int idx1 = n/2 , idx2 = idx1-1 , cnt = 0 ;
        double ele1 = -1d , ele2 = -1d;

        int i = 0 , j = 0;

        while(i<n1 && j<n2){
            if(nums1[i] < nums2[j]){
                if(cnt == idx1)ele1 = nums1[i];
                if(cnt == idx2)ele2 = nums1[i];
                i++;
                cnt++;
            }else{
                if(cnt == idx1)ele1 = nums2[j];
                if(cnt == idx2)ele2 = nums2[j];
                j++;
                cnt++;
            }
        }

        while(i<n1){
            if(cnt == idx1)ele1 = nums1[i];
            if(cnt == idx2)ele2 = nums1[i];
            i++;
            cnt++;
        }

        while(j<n2){
            if(cnt == idx1)ele1 = nums2[j];
            if(cnt == idx2)ele2 = nums2[j];
            j++;
            cnt++;
        }

        if(n%2 == 1)return (double)ele1;
        else{
            return (ele1+ele2)/(double)2;
        }
    }
}
