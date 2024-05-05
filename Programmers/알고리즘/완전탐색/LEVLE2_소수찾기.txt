import java.util.Collections;
import java.util.HashSet;
import java.util.Arrays;
class Solution {
    static HashSet<Integer> ar = new HashSet<>();
    public int solution(String numbers) {
        int answer = 0;
        int len = numbers.length();
        char[] out = new char[len];
        boolean[] check = new boolean[len];
        
        
        for(int i = 1 ; i < len+1; i++){
            dfs(numbers, out, check, 0, i, len);
            check = new boolean[len];
        }
        
        int max = Collections.max(ar);
        
        
        boolean[] isPrime = new boolean[max+1];
        isPrime[0] = isPrime[1] = true;
        
        for(int i=2; i*i<=max; i++){
            if(!isPrime[i]){
            	for(int j=i*i; j<=max; j+=i) isPrime[j]=true;                
            }        
        }   
        for(int i : ar){
            if(!isPrime[i]) answer++;
        }
        
        return answer;
    }
    
    
    static void dfs(String nums, char[] out, boolean[] check, int c, int r, int cnt){
        if(c == r){
            String num = new String(Arrays.copyOfRange(out, 0, r));
            ar.add(Integer.parseInt(num));    
           
        }
        for(int i = 0 ; i < cnt; i++){
            if(check[i] != true){
                check[i] = true;
                out[c] = nums.charAt(i);
                dfs(nums, out, check, c+1, r, cnt);
                check[i] = false;
            }
        }
    }
    
}