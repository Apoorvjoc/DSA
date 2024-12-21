package SlidingWindowAnd2Pointers;

import java.util.ArrayList;
import java.util.List;
// <->
public class GenerateAllSubstringOfString {

    public static void main(String[] args) {
        List<String> str =  generateAllSubstr("apple");
        System.out.println(str);
        //o/p : [a, ap, app, appl, apple, p, pp, ppl, pple, p, pl, ple, l, le, e]

        //mathematical formula : (length * (length + 1)) / 2
        // length of apple : 5 => 5 * 6 / 2 => 15

        // if you need to count for any specific length then count : L - n + 1 where l = length of str , n = length of string we want to count
        // in apple substring of length 2 : 5 - 2 + 1 = 4 => [ap pp pl le]
    }

    public static List<String> generateAllSubstr(String s){
        int n = s.length();
        List<String> strings = new ArrayList<>();

        for(int i = 0 ; i<n ; i++){
            String str = "";
            for(int j = i ; j<n ; j++){
                str += s.charAt(j);
                strings.add(str);
                System.out.print(str + " ");
            }
            System.out.println();
        }

        return strings;
    }
}
