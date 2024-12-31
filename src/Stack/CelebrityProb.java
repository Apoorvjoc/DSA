package Stack;

import java.util.Stack;

public class CelebrityProb {
    public int celebrity(int mat[][]) {
        // code
        int n = mat.length;

        int knowMe[] = new int[n];
        int iKnow[] = new int[n];

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ; j++){
                if(mat[i][j] == 1){
                    iKnow[i] += 1; // element at ith row
                    knowMe[j] += 1;
                }
            }
        }

        for(int i = 0 ; i<n ; i++){
            if(iKnow[i] == 0 && knowMe[i] == n - 1)return i;
        }

        return -1;
    }
}

class CelebrityProb_optimal {
    public int celebrity(int mat[][]) {
            // code
            int n = mat.length;

            Stack<Integer> st = new Stack();

            for(int i = 0 ; i<n ; i++)st.add(i);

            while(st.size() > 1){
                int i = st.pop();
                int j = st.pop();

                if(mat[i][j] == 1){
                    st.add(j); // i knows j there fore i cannot be a celebrity , j might me celebrity as i knows j
                }else if(mat[j][i] == 1){
                    st.add(i); // j knows i there fore j cannot be a celebrity , i might me celebrity as j knows i
                }
            }

            int potentialCelebrity = st.pop();

            for(int i = 0 ; i<n ; i++){
                if(i == potentialCelebrity) continue; //eliminate diagonal

                if(mat[potentialCelebrity][i] == 0 && mat[i][potentialCelebrity] == 1){
                    //DO NOTHING
                }else return -1;
            }

            return potentialCelebrity;
        }
}
