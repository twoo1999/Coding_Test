import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Queue<Integer> main = new LinkedList<>();
        Stack<Integer> sub = new Stack<>();
        int len = order.length;
        for(int i = 1 ; i <= len ; i++){
            main.offer(i);
        }
        
        int idx = 0;
        while(!main.isEmpty()){
            int mainBox = main.peek();
            int subBox;
            try{
                subBox = sub.peek();
            } catch(Exception e){
                subBox = -1;
            }
            
            if(mainBox == order[idx]){
                answer++;
                idx++;
                main.poll();
            } else if(subBox == order[idx]){
                answer++;
                idx++;
                sub.pop();
            } else{
                sub.push(main.poll());
            }
        }
        
        while(!sub.isEmpty()){
            int subBox = sub.peek();
            if(subBox == order[idx]){
                answer++;
                idx++;
                sub.pop();
            } else {
                break;
            }
            
        }
        
        
        
        return answer;
    }
}