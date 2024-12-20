package SlidingWindowAnd2Pointers;

import java.util.HashMap;

// TC : n * n
// SC o(256) or constant
public class LongestSubStrWithNonRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length() , ans = 0;

        for(int i = 0 ; i<n ; i++){
            int hash[] = new int[255]; // in ascii format character is int range 0 - 255;
            for(int j = i ; j<n ; j++){
                if(hash[s.charAt(j)] == 1) break; // exit from inner loop and start forming string from next character ,
                //as current char is equivalent to starting char ex : str = abcabb => for substr =>  abca "a" is repeating therefore now count string which is starting from b

                ans = Math.max(ans , j - i + 1);
                hash[s.charAt(j)] = 1;
            }
        }

        return ans;
    }
}

class LongestSubStrWithNonRepeatingChar_otimized {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length() , ans = 0 , l = 0 , r = 0;
        HashMap<Character , Integer> hm = new HashMap();

        while(r < n){
            char ch = s.charAt(r);
            hm.put(ch , hm.getOrDefault(ch , 0) + 1);

            while(hm.get(ch) > 1){
                char lch = s.charAt(l);
                hm.put(lch , hm.get(lch) - 1);
                l++;
            }

            ans = Math.max(ans , r - l + 1);
            r++;
        }

        return ans;
    }
}


