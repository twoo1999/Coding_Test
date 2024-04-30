import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<int[]> q = new LinkedList<>();
        int totalW =truck_weights[0];
        int time = 1;
        int idx = 1;
        q.offer(new int[]{truck_weights[0], 1});
        while(idx < truck_weights.length || !q.isEmpty()){
            
            time++;
            int[] val = q.peek();
            if(val != null && time - val[1] == bridge_length){
                q.poll();
                totalW -= val[0];
            }
            if(idx < truck_weights.length){
                int w = truck_weights[idx];
//             // val , time
            
                if(totalW + w <= weight){
                    q.offer(new int[]{w, time});
                    totalW += w;
                    idx++;
                }    
            }
            
            
        }
        
        
        return time;
    }
}