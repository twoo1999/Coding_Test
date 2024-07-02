import java.util.*;


class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int cnt = n;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int w : works){
            pq.add(w);
        }
        
        while(cnt-- != 0){
            if(pq.isEmpty()){
                return 0;
            }
            
            int remain = pq.poll()-1;
            
            
            if(remain != 0){
                pq.add(remain);
            }
            
            
            
            
        }
        
        
        for(int w : pq){
            answer += Math.pow(w, 2);
        }
        
        
        
        
        return answer;
    }
}