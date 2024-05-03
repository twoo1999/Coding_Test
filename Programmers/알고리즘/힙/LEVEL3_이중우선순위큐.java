import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {};
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < operations.length; i++){
            String[] op = operations[i].split(" ");
            String type = op[0];
            String val = op[1];
            
            if(type.equals("I")){
                pq.offer(Integer.parseInt(val));
            } else {
                if(val.equals("-1")){
                    pq.poll();
                } else{
                    PriorityQueue<Integer> temp = new PriorityQueue<>();
                    int l = pq.size();
                    for(int j = 0 ; j < l-1; j++){
                        temp.offer(pq.poll());
                    }
                    pq = temp;
                }
            }
            
            
        }
        
       
        int len = pq.size();
        int min = 0;
        int max = 0;
        for(int i = 0; i < len; i++){
            if(i == 0){
                min = pq.poll();
            }
            else if(i == len-1){
                max = pq.poll();
            } else{
                pq.poll();
            }
        }
      
        return new int[]{max, min};
    }
}