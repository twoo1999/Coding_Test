import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    static ArrayList<String> ar = new ArrayList<>();
    public int solution(String word) {
        int answer = 0;
        char[] alpha = {'A', 'E', 'I', 'O', 'U'};
        boolean[] check = new boolean[5];
        char[] result = new char[5];
        
        
        for(int i = 1 ; i <= 5; i++){
            dfs(alpha, check, result, 0, i);
        }
        Collections.sort(ar);
        for(int i = 0; i < ar.size(); i++){
            if(word.equals(ar.get(i))){
                return i+1;
            }
        }
        return answer;
    }
    
    static void dfs(char[] alpha,boolean[] check, char[] result, int cnt, int depth){
        if(cnt == depth){
            ar.add(new String(Arrays.copyOfRange(result, 0, depth)));
            return;
        }
        for(int i = 0 ; i < alpha.length; i++){
            result[cnt] = alpha[i];
            dfs(alpha, check, result, cnt+1, depth);
        }
        
    }
}