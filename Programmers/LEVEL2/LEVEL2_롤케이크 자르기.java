import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = -1;
        HashMap<Integer, Integer> lmap = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int t: topping){
            if(map.containsKey(t)){
                map.put(t, map.get(t) + 1);
            }else{
                map.put(t, 1);
            }
        }

        int ans = 0;
        for(int t : topping){
            putMap(lmap, t);
            deleteMap(map, t);
            if(map.size() == lmap.size()) ans++;

        }
        
        
        return ans;
    }
    
    static void deleteMap(HashMap<Integer, Integer> map, int d){
        if(map.get(d) != 1){
            map.put(d, map.get(d)-1);
        } else {
            map.remove(d);
        }
    }
    static void putMap(HashMap<Integer, Integer> map, int d){
        if(map.containsKey(d)){
            map.put(d, map.get(d) + 1);
        }else{
            map.put(d, 1);
        }
    }
}