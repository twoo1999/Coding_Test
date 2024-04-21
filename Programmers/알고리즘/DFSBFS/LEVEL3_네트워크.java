import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        
        boolean[] check = new boolean[n];
        Arrays.fill(check, false);
 
        while(findNotCheck(check) != -1){
            int start = findNotCheck(check);
            answer++;
            q.offer(start);
            while(!q.isEmpty()){
                int pos = q.poll();
                for(int i = 0 ; i < n; i++){
                    if(i != pos && !check[i] && computers[pos][i] == 1){
                        q.offer(i);
                    }
                }
                check[pos] = true;
            }
            
        }
        
        
        
        return answer;
    }
    
    public static int findNotCheck(boolean[] check){
        for(int i = 0; i < check.length; i++){
            if(!check[i]){
                return i;
            }
        }
        
        return -1;
    }
}