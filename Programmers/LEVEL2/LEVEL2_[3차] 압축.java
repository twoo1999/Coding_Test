import java.util.*;

class Solution {
    public int[] solution(String msg) {
        int[] answer = {};
        
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < 26; i++){
            map.put(String.valueOf((char)('A'+i)), i+1);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(msg.length() > 0){
            StringBuilder sb = new StringBuilder();
            int i = 0;
            String key = "";
            for(i = 0 ; i < msg.length(); i++){
                key = sb.toString() + String.valueOf(msg.charAt(i));
                if(!map.containsKey(key)){
                    break;
                } else{
                    sb.append(msg.charAt(i));
                }
            }

            if(!key.equals(msg)){
                map.put(key, map.size()+1);
            }

            ans.add(map.get(sb.toString()));
            msg = msg.substring(sb.length());

        }
        
        return ans.stream().mapToInt(i->i).toArray();
    }
}