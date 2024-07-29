import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        ArrayList<Long> ans = new ArrayList<>();
        
        for(long num : numbers){
            String a = Long.toString(num, 2);
            StringBuilder sb = new StringBuilder(a);
            if(sb.chars().filter(c->c=='1').count() == sb.length()){
                sb.insert(0, "0");
            }
            int idx =0 ;
            for(idx = sb.length()-1; idx >= 0; idx--){
                if(sb.charAt(idx) == '0') break;
            }
            sb.replace(idx, idx+1, "1");
            if(idx != sb.length()-1){
                for(int i = idx+1; i < sb.length(); i++){
                    if(sb.charAt(i) == '1'){
                        sb.replace(i, i+1, "0");
                        break;
                    }
                }
            }
            ans.add(Long.parseLong(sb.toString(), 2));
        }
        long[] arr = new long[ans.size()];
        for(int i = 0 ; i < arr.length; i++){
            arr[i] = ans.get(i);
        }
        return arr;
    }
}