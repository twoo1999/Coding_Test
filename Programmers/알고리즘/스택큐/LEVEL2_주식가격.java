import java.util.Stack;
import java.util.LinkedList;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<int[]> s = new Stack<>();
        // idx, val
        s.push(new int[]{0, prices[0]});
        
        for(int i = 1 ; i < prices.length; i++){
            int val = prices[i];
            while(!s.isEmpty()){
                int[] pop = s.peek();
                if(pop[1] > val){
                    answer[pop[0]] = i - pop[0];
                    s.pop();
                } else{
                    s.push(new int[]{i, prices[i]});
                    break;
                }
            }
            s.push(new int[]{i, prices[i]});
        }
        
        while(!s.isEmpty()){
                int[] pop = s.pop();
                answer[pop[0]] = prices.length-1-pop[0];
            }
        
        return answer;
    }
}