package SlidingWindowAnd2Pointers;

import java.util.*;

//https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<HashMap<Character , Integer>, List<String>> hm = new HashMap();

        for(String str : strs){
            //making freq map
            HashMap<Character , Integer> fm = new HashMap();
            for(char ch : str.toCharArray()){
                fm.put(ch , fm.getOrDefault(ch , 0) + 1);
            }

            //if similar freq already exists then
            if(hm.containsKey(fm)){
                List<String> l = hm.get(fm);
                l.add(str);
            }else{ // if not then create entry;
                List<String> l = new ArrayList();
                l.add(str);
                hm.put(fm , l);
            }

        }

        List<List<String>> ans = new ArrayList();

        for(HashMap<Character , Integer> key : hm.keySet()){
            ans.add(hm.get(key));
        }

        return ans;
    }
}

class GroupAnagramOptimal{
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars); // making key as unique
            String sortedWord = new String(chars);

            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            map.get(sortedWord).add(word); // getting list and putting new value in that
        }

        return new ArrayList<>(map.values());
    }
}
