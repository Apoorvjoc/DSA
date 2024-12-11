package RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/palindrome-partitioning/description/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList();
        List<String> sans = new ArrayList();
        helper(0 , s , sans , ans);
        return ans;
    }

    private void helper(int idx , String s , List<String> sans , List<List<String>>ans){
        if(s.length() == idx){
            ans.add(new ArrayList(sans));
            return;
        }

        for(int i = idx ; i<s.length() ; i++){
            String currSubstring = s.substring(idx , i+1);
            if(isPalindrome(currSubstring)){
                sans.add(currSubstring);
                helper(i+1 , s , sans , ans);
                sans.remove(sans.size() - 1);
            }
        }

    }

    private boolean isPalindrome(String currSubstring){
        int s = 0 , e = currSubstring.length()-1;
        while(s<=e){
            if(currSubstring.charAt(s++) != currSubstring.charAt(e--))return false;
        }
        return true;
    }
}
