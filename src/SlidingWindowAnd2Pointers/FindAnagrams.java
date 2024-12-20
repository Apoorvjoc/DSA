package SlidingWindowAnd2Pointers;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length() , plength = p.length();
        String substr = "";
        List<Integer> ans = new ArrayList();

        for(int i = 0 ; i<n ; i++){
            substr = "";
            for(int j = i ; j<n ; j++){
                substr += s.charAt(j);
                if(substr.length() > plength)break;

                if(isAnagram(substr , p)){
                    ans.add(j - plength + 1);
                    break;
                }
            }
        }

        // System.out.println(isAnagram("abc" , "ba"));

        return ans;
    }

    private boolean isAnagram(String substr , String p){
        int hash[] = new int[255];

        if (substr.length() != p.length()) {
            return false;
        }

        for(int i = 0 ; i<substr.length() ; i++){
            int idx = substr.charAt(i);
            hash[idx]++;
        }

        for(int i = 0 ; i<p.length() ; i++){
            int idx = p.charAt(i);
            hash[idx]--;
        }

        for(int i = 0 ; i<255 ; i++){
            if(hash[i] != 0)return false;
        }

        System.out.println("True for " + substr + " " + p);

        return true;
    }
}

class FindAnagrams_optimal {
    public List<Integer> findAnagrams(String s, String p) {
        int n = s.length() , plength = p.length();
        String substr = "";
        List<Integer> ans = new ArrayList();

        for(int i = 0 ; i<n ; i++){
            substr = "";
            for(int j = i ; j<n ; j++){
                substr += s.charAt(j);
                if(substr.length() > plength)break;

                if(isAnagram(substr , p)){
                    ans.add(j - plength + 1);
                    break;
                }
            }
        }

        // System.out.println(isAnagram("abc" , "ba"));

        return ans;
    }

    private boolean isAnagram(String substr , String p){
        int hash[] = new int[255];

        if (substr.length() != p.length()) {
            return false;
        }

        for(int i = 0 ; i<substr.length() ; i++){
            int idx = substr.charAt(i);
            hash[idx]++;
        }

        for(int i = 0 ; i<p.length() ; i++){
            int idx = p.charAt(i);
            hash[idx]--;
        }

        for(int i = 0 ; i<255 ; i++){
            if(hash[i] != 0)return false;
        }

        System.out.println("True for " + substr + " " + p);

        return true;
    }
}
