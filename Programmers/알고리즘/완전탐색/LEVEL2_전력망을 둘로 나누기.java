import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = 101;
        Queue<Integer> q = new LinkedList<>();
        
        
        for(int i = 0 ; i < wires.length; i++){
            int[][] temp = new int[wires.length -1][2];
            int idx = 0;
            for(int j = 0 ; j < wires.length; j++){
                if(i != j){
                    temp[idx++] = wires[j];
                }
            }
  
            q.offer(temp[0][0]);
            boolean[] check = new boolean[n+1];
            check[0] = true;
            int x = 0;
            int z=  0;
            while(true){
                while(!q.isEmpty()){
                    int cur = q.poll();
                    x += (z == 1)? 1 : -1;
                    check[cur] = true;
                    for(int j = 0 ; j < temp.length; j++){
                        int[] next = temp[j];
                        if(cur == next[0] && !check[next[1]]){
                            q.offer(next[1]);
                        } else if(cur == next[1] && !check[next[0]]){
                            q.offer(next[0]);
                        }
                    }
                }
                
                for(int j = 1 ; j <= n; j++){
                    if(check[j] != true){
                        q.offer(j);
                        break;
                    }
                }
                
                if(q.isEmpty()){
                    break;
                }
                z++;
            }
            answer = answer > Math.abs(x) ? Math.abs(x) : answer;
        }
        
        return answer;
    } 
    
}