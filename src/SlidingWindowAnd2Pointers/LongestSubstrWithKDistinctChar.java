package SlidingWindowAnd2Pointers;

import java.util.HashMap;

//https://www.naukri.com/code360/problems/longest-sub-string-with-k-distinct-characters_920521?leftPanelTabValue=PROBLEM
public class LongestSubstrWithKDistinctChar {
    //TC : o(N + N + 256) outer while , inner while and hashmap
    public static int getLengthofLongestSubstring(String s, int k) {
        // Write your code here.
        int l = 0 , r = 0 , n = s.length() , ans = 0;
        HashMap<Character , Integer> hm = new HashMap<>();

        while(r<n){
            Character ch = s.charAt(r);
            hm.put(ch , hm.getOrDefault(ch, 0) + 1);

            while(hm.size()>k){
                Character lch = s.charAt(l);
                hm.put(lch, hm.get(lch) - 1);
                if(hm.get(lch) == 0)hm.remove(lch);
                l++;
            }

            ans = Math.max(ans , r - l + 1);
            r++;
        }

        return ans;
    }
}

class bruteForce{
    public static int getLengthofLongestSubstring(String s, int k) {
        // Write your code here.
        int l = 0 , r = 0 , n = s.length() , ans = 0;

        String currStr = "";

        for(int i = 0 ; i<n ; i++){
            currStr = "";
            for(int j = i ; j<n ; j++){
                currStr += s.charAt(j);
                if(currStr.chars().distinct().count() > k){
                    break;
                }
                ans = Math.max(ans , j - i + 1);
            }
        }

        return ans;
    }
}
