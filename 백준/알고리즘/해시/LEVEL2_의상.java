import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i = 0 ; i< clothes.length; i++){
            String type = clothes[i][1];
            if(!map.containsKey(type)){
                map.put(type, 2);
            } else{
                map.put(type, map.get(type)+1);
            }
        }
        
        for(String key: map.keySet()){
            answer *= map.get(key);
        }
               
        
        return answer-1;
    }
}