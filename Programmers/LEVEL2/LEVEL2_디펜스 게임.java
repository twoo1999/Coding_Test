import java.util.*;
import java.util.stream.Collectors;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        int idx = 0;

        for (idx = 0; idx < enemy.length; idx++) {
            int e = enemy[idx];
            sum += e;
            pq.add(e);
            if(sum > n){
                if(k == 0){
                    break;
                }
                sum -= pq.poll();
                k--;
            }

        }
        return idx;
    }
    
  
}