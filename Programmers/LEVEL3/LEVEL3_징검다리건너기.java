import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        int cnt = stones.length;
        
        Deque<Integer> dq = new LinkedList<>();
        int max = Integer.MAX_VALUE;
        
        for(int i = 0 ; i < cnt; i++){
            while(!dq.isEmpty() && dq.peek() < i- k +1){
                dq.pollFirst();
            }
            
            while(!dq.isEmpty() && stones[dq.peekLast()] < stones[i]){
                dq.pollLast();
            }
            
            dq.offer(i);
            
            if(i >= k-1){
                if(max >= stones[dq.peekFirst()]){
                    max = stones[dq.peekFirst()];
                }
            }
        }
        
        return max;
    }
}