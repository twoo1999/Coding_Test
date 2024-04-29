import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;
import java.util.ArrayList;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> pri = new ArrayList<>();
        
        for(int i = 0 ; i < priorities.length; i++){
            q.offer(i);
            pri.add(priorities[i]);
        }
        
        Collections.sort(pri, (Integer x, Integer y)->{
            return y-x;
        });
        int priIdx = 0;
        while(!q.isEmpty()){
            int maxPri = pri.get(priIdx);
            int num = q.poll();
            int realVal = priorities[num];
            if(realVal == maxPri){
                answer++;
                priIdx++;
                if(num == location){
                    break;
                }
            } else{
                q.offer(num);
            }
            
        }
        
        return answer;
    }
    
    
}