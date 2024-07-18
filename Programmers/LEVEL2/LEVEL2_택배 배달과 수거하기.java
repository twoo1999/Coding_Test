import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Stack<Integer> dst = new Stack<>();
        Stack<Integer> pst = new Stack<>();
        
        for(int i = 0; i < n; i++){
            dst.push(deliveries[i]);
        }

        for(int i = 0; i  < n; i++){
            pst.push(pickups[i]);
        }
        
        while(!dst.isEmpty() || !pst.isEmpty()){
            int box = 0;
            int ddis = 0;
            int pdis = 0;
            while(box < cap){

                if(dst.isEmpty()) break;
                int cnt = dst.peek();

                if(cnt != 0 && ddis == 0){
                    ddis = dst.size();
                }
                cnt = dst.pop();
                if(cnt > cap - box){
                      dst.push(cnt-(cap-box));
                      box = cap;
                } else{
                    box += cnt;
                }



            }
            box = 0;
            while(box < cap){
                if(pst.isEmpty()) break;

                int cnt = pst.peek();

                if(cnt != 0 && pdis == 0){
                    pdis = pst.size();
                }
                cnt = pst.pop();
                if(cnt > cap - box){
                    pst.push(cnt - (cap - box));
                    box = cap;
                } else {
                    box += cnt;
                }


            }

            answer +=  ((pdis > ddis) ? pdis : ddis) * 2;


        }
        
        
        return answer;
    }
}