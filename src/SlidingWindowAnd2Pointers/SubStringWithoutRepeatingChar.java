package SlidingWindowAnd2Pointers;

import java.util.HashMap;

public class SubStringWithoutRepeatingChar {

    public static void main(String[] args) {
        System.out.println(calcCount("aab"));
        //examples
        //aabcbcdbca => 24
        //abcd => 10
        //000 => 3
        //abab => 7
    }

    private static int calcCount(String str){
        int ans=0;

        int l = 0 , r = 0 , n = str.length();
        HashMap<Character , Integer> hm = new HashMap<>();
        //zabca
        while (r<n){
           Character ch = str.charAt(r);
           hm.put(ch , hm.getOrDefault(ch , 0) + 1);

           while(hm.get(ch) > 1){
               Character lch = str.charAt(l);
               hm.put(lch , hm.get(lch) - 1);
               if(hm.get(lch) == 0)hm.remove(lch);
               l++;
           }
           ans += (r-l+1);
           r++;
        }

        return ans;
    }
}
