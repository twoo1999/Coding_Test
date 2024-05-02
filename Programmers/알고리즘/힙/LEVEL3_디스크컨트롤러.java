import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)->{
            return x[1] - y[1];
        });
        
 
        int time = 0;
        int cnt = 0;
        int[] curr = null;
        int start = 0;
        while(!(cnt == jobs.length && curr == null)){            
            for(int i = 0 ; i < jobs.length; i++){
                if(time == jobs[i][0]){
                    pq.offer(jobs[i]);
                }
            }
            
            if(!pq.isEmpty()){
                if(curr == null){
                    curr = pq.poll();    
                    start = time;
                } 
            }
                
            if(curr != null){
                if(time-start == curr[1]){
                    answer += time-curr[0];
                    cnt++;
                    curr = pq.poll();
                    start = time;    
                }
            }    

            time++;
        }
        
        return answer/jobs.length;
    }
}