package SlidingWindowAnd2Pointers;

//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/
//TC : n*n
public class NumberOfSubstrContaining3Characters {
    public int numberOfSubstrings_bruteforce(String s) {
        int n = s.length() , cnt = 0 ;
        for(int i = 0 ; i<n ; i++){
            int hash[] = new int[3];
            for(int j = i ; j<n ; j++){
                hash[s.charAt(j) - 'a'] = 1;
                if(hash[0] + hash[1] + hash[2] == 3)cnt++;
            }
        }
        return cnt;
    }
}

//Still TC : n * n
class NumberOfSubstrContaining3Characters_Better{
    public int numberOfSubstrings(String s) {
        int n = s.length() ,cnt = 0 ;
        for(int i = 0 ; i<n ; i++){
            int hash[] = new int[3];
            for(int j = i ; j<n ; j++){
                hash[s.charAt(j) - 'a'] = 1;
                if(hash[0] + hash[1] + hash[2] == 3){
                    cnt = cnt + (n-j);
                    break;
                }
            }
        }
        return cnt;
    }
}

class NumberOfSubstrContaining3Characters_Optimalr{
    public int numberOfSubstrings(String s) {
        int n = s.length() ,cnt = 0 ;
        int lastSeen[] = {-1 , -1 , -1};

        for(int i = 0 ; i<n ; i++){
            int charAscii = s.charAt(i);
            lastSeen[charAscii - 'a'] = i;

            //if all the values are non -ve (default value) then take min idx value of 3 and add 1 to it , store them in ans
            if(lastSeen[0] >= 0 && lastSeen[1] >= 0 && lastSeen[2] >= 0 ){
                cnt = cnt + Math.min(lastSeen[0] , Math.min(lastSeen[1] , lastSeen[2])) + 1; // +1 for current substring and min value to find substring from => (min idx till 0)
            }
        }

        return cnt;
    }
}


