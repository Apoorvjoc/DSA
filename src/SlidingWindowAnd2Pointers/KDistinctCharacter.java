package SlidingWindowAnd2Pointers;

import java.util.HashMap;

//https://takeuforward.org/plus/data-structures-and-algorithm/sliding-window-and-2-pointer/longest-and-smallest-window-problems/longest-substring-with-at-most-k-distinct-characters
// TC : n * n * o(256)
// SC : o(256)
public class KDistinctCharacter {
    public int kDistinctChar(String s, int k) {
        //your code goes here
        int n = s.length() , ans = 0;
        for(int i = 0 ; i<n ; i++){
            HashMap<Character , Integer> hm = new HashMap();
            for(int j = i ; j<n ; j++){
                Character ele = s.charAt(j);

                if(hm.containsKey(ele)){
                    int val = hm.get(ele);
                    val++;
                    hm.put(ele , val);
                }else{
                    hm.put(ele , 1);
                }

                if(hm.size() > k)break;

                ans = Math.max(ans , j - i + 1);
            }
        }
        return ans;
    }
}

//TC : n + n
class kDistinctCharBetter{

    public int kDistinctChar(String s, int k) {
        //your code goes here
        int n = s.length() , ans = 0;
        int l = 0 , r = 0;

        HashMap<Character , Integer> hm = new HashMap();

        while(r<n){
            Character ele = s.charAt(r);

            hm.put(ele, hm.getOrDefault(ele, 0) + 1);

            //check if current segment is valid or not
            while(hm.size() > k){
                Character left = s.charAt(l);
                hm.put(left, hm.get(left) - 1);
                int val = hm.get(left);
                if(val == 0) hm.remove(left);
                l++;
            }

            ans = Math.max(ans , r - l + 1);
            r++;
        }

        return ans;
    }
}
//TC : o(n)
class kDistinctCharOptimal{

    public int kDistinctChar(String s, int k) {
        //your code goes here
        int n = s.length() , ans = 0;
        int l = 0 , r = 0;

        HashMap<Character , Integer> hm = new HashMap();

        while(r<n){
            Character ele = s.charAt(r);

            hm.put(ele, hm.getOrDefault(ele, 0) + 1);

            //check if current segment is valid or not
            if(hm.size() > k){ // this if will decrease complexity from o(2n) to o(n)
                Character left = s.charAt(l);
                hm.put(left, hm.get(left) - 1);
                int val = hm.get(left);
                if(val == 0) hm.remove(left);
                l++;
            }

            ans = Math.max(ans , r - l + 1);
            r++;
        }

        return ans;
    }
}
