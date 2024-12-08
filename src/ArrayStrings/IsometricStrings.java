package ArrayStrings;

import java.util.HashMap;
import java.util.Map;

public class IsometricStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character , Integer> shm = new HashMap();
        HashMap<Character , Integer> thm = new HashMap();

        for(int i = 0 ; i<s.length() ; i++){
            char chs = s.charAt(i);
            char cht = t.charAt(i);

            if(!shm.containsKey(chs)){
                shm.put(chs , i);
            }

            if(!thm.containsKey(cht)){
                thm.put(cht , i);
            }

            if(!shm.get(chs).equals(thm.get(cht)))return false;
        }


        return true;
    }
}

class isometricApp2{
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;  // Check if lengths are different

        Map<Character, Character> map = new HashMap<>();  // HashMap to store mappings

        for (int i = 0; i < s.length(); i++) {  // Loop through the strings
            char c1 = s.charAt(i);  // Character from s
            char c2 = t.charAt(i);  // Character from t

            if (map.containsKey(c1)) {  // If c1 is already mapped
                if (map.get(c1) != c2) {  // Check if the mapping is correct
                    return false;
                }
            } else {  // If c1 is not mapped
                if (map.containsValue(c2)) {  // Check if c2 is already mapped to another char
                    return false;
                }
                map.put(c1, c2);  // Add the mapping
            }
        }

        return true;  // Return true if no conflicts
    }
}
