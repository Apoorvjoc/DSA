package Graphs;

import java.util.*;

public class WordLadderOne {
    class Pair{
        String word;
        int lvl;

        Pair(String word , int lvl){
            this.word = word;
            this.lvl = lvl;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList();
        q.add(new Pair(beginWord , 1));
        Set<String> st = new HashSet(wordList);
        st.remove(beginWord);

        // bfs algo
        while(!q.isEmpty()){
            Pair front = q.poll();
            String word = front.word;
            int lvl = front.lvl;

            //if we found the word
            if(word.equals(endWord)) return lvl;

            char chArr[] = word.toCharArray();
            for(int i = 0 ; i<word.length() ; i++){
                char chi = chArr[i];
                for(char ch = 'a' ; ch<='z' ; ch++){
                    chArr[i] = ch;
                    String modifiedString = String.valueOf(chArr);
                    if(st.contains(modifiedString)){
                        q.add(new Pair(modifiedString , lvl + 1));
                        st.remove(modifiedString);
                    }
                }
                chArr[i] = chi;
            }

        }

        return 0;
    }
}
