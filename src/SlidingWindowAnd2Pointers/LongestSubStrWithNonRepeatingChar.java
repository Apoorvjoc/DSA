package SlidingWindowAnd2Pointers;

// TC : n * n
// SC o(256) or constant
public class LongestSubStrWithNonRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length() , ans = 0;

        for(int i = 0 ; i<n ; i++){
            String str = "";
            int hash[] = new int[255]; // in ascii format character is int range 0 - 255;
            for(int j = i ; j<n ; j++){
                if(hash[s.charAt(j)] == 1) break; // exit from inner loop and start forming string from next character ,
                //as current char is equivalent to starting char ex : str = abcabb => for substr =>  abca "a" is repeating therefore now count string which is starting from b

                str += s.charAt(j);
                ans = Math.max(ans , j - i + 1);
                hash[s.charAt(j)] = 1;
            }
        }

        return ans;
    }
}
