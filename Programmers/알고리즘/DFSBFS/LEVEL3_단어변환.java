import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;
class Solution {
    static int re = 1000;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        int len = words.length;
        int cnt = 0;
        boolean[] check = new boolean[len];
        Arrays.fill(check, false);

        for(int i = 0 ; i < len; i++){
            if(getDiffAlphabet(begin, words[i]) == 1){
                dfs(words, words[i], target, cnt+1, check);
            }
        }
        

        
        
        return re==1000?0 : re;
    }
    
    public static void dfs(String[] words, String begin, String target, int cnt, boolean[] check){
        if(begin.equals(target)){

            re = Math.min(cnt, re);
        }
        for(int i = 0 ; i < words.length; i++){
            if(getDiffAlphabet(begin, words[i]) == 1 && !check[i]){
                check[i] = true;
                dfs(words, words[i], target, cnt+1, check);
                check[i] = false;
            }
            
        }
    }
    public static int getDiffAlphabet(String x, String y){
        int len = x.length();
        int r = 0;
        for(int i = 0; i < len; i++){
            if(x.charAt(i) != y.charAt(i)){
                r++;
            }
        }
        
        return r;
    }
    
    
    
}