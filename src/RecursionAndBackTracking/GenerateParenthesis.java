package RecursionAndBackTracking;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/description/
//TC : 2 ^ N  , SC : O(N)
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        helper(0 , 0 , ans , "" , n);
        return ans;
    }

    public void helper(int open , int close , List<String> ans , String str , int n){
        if(open == n && close == n){
            ans.add(str);
            return;
        }

        if(open < n){
            str += "(";
            open++;
            helper(open , close , ans , str , n);
            open--;
            str = str.substring(0 , str.length()-1);
        }

        if(open > close){
            str += ")";
            close++;
            helper(open , close , ans , str , n);
            // below 2 calls will never happen, can draw recursive tree to analyse
            close--;
            str = str.substring(0 , str.length()-1);
        }
    }
}
