import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        
        while(pq.peek() < K){
            int x = pq.poll();
            if(pq.peek() == null){
                break;
            }
            int y = pq.poll();
            
            pq.offer(x + y * 2);
            answer++;
        }
        
        
        return pq.peek() == null ? -1 : answer;
    }
    
   
}