package SlidingWindowAnd2Pointers;

import java.util.HashMap;

public class LongestRepeatingCharWihReplacement {
    public int characterReplacement(String s, int k) {
        int n = s.length() , majorityElement = 0 , ans = 0;
        int hash[] = new int[256];

        for(int i = 0 ; i<n ; i++){
            hash = new int[256];
            for(int j = i ; j<n ; j++){
                hash[s.charAt(j)]++;
                //max freq element
                majorityElement = Math.max(majorityElement , hash[s.charAt(j)]);
                int changesToFlipChar = ((j - i + 1) - majorityElement);
                if(changesToFlipChar > k)break;  // if k < then number of changes required then ans wont be possible
                ans = Math.max(ans , j - i + 1); // otherwise current window may be our possible ans
            }
        }
        return ans;
    }
}

class LongestRepeatingCharWihReplacement_optimal {
    public int characterReplacement(String s, int k) {
        int n = s.length() , majorityElement = 0 , ans = 0 , r = 0 , l = 0;
        HashMap<Character ,Integer> hm = new HashMap<>();

        while(r < n){
            char ch = s.charAt(r);

            hm.put(ch , hm.getOrDefault(ch , 0)+1);

            majorityElement = Math.max(majorityElement , hm.get(ch));
            int changeToFlipChar = (r - l + 1) - majorityElement;

            if(changeToFlipChar > k){
                char leftChar = s.charAt(l);
                hm.put(leftChar , hm.get(leftChar) - 1);
                if(hm.get(leftChar) == 0)hm.remove(leftChar);
                l++;
            }

            ans = Math.max(ans , r - l + 1);


            r++;
        }

        return ans;
    }
}


//using int hash array will always better than using hashmap
class withoutUsingHashMap{
    public int characterReplacement(String s, int k) {
        int n = s.length() , majorityElement = 0 , ans = 0 , r = 0 , l = 0;
        int hash[] = new int[256];
        while(r < n){
            char ch = s.charAt(r);
            hash[ch]++;

            majorityElement = Math.max(majorityElement , hash[ch]);
            int changeToFlipChar = (r - l + 1) - majorityElement;

            if(changeToFlipChar > k){ // while can be replaced with if b/c if length l window is present we wont go below that
                char leftChar = s.charAt(l);
                hash[leftChar]--;
                l++;
            }

            ans = Math.max(ans , r - l + 1);

            r++;
        }

        return ans;
    }
}