package RecursionAndBackTracking;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/word-break/description/
// TC : 2 ^ n (2 choices for each element in string)
// SC : n for set
public class WordBreak1 {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> st = new HashSet(wordDict);

        return helper(0 , s , st);
    }

    private boolean helper(int idx , String s , Set<String>wordSet){
        if (idx == s.length()) {
            return true; // If we've processed the entire string, return true
        }

        // Try every possible substring starting from idx
        for (int i = idx; i < s.length(); i++) {
            String substr = s.substring(idx, i+1);
            if (wordSet.contains(substr)) { // If the substring is in the wordDict
                // Recursively check the remaining substring
                if (helper(i + 1, s, wordSet)) {
                    return true;
                }
            }
        }

        return false;
    }
}
// TC : n ^ 2 => substring method
// SC : n => recursive and memoization
// this will submit with no TLE
class WordBreak1Memo {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> st = new HashSet(wordDict);

        return helper(0 , s , st);
    }

    private boolean helper(int idx , String s , Set<String>wordSet){
        if (idx == s.length()) {
            return true; // If we've processed the entire string, return true
        }

        // Try every possible substring starting from idx
        for (int i = idx; i < s.length(); i++) {
            String substr = s.substring(idx, i+1);
            if (wordSet.contains(substr)) { // If the substring is in the wordDict
                // Recursively check the remaining substring
                if (helper(i + 1, s, wordSet)) {
                    return true;
                }
            }
        }

        return false;
    }
}