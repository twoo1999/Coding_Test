import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
class Solution {
    static ArrayList<String> ar = new ArrayList<>();
    static HashSet<ArrayList<String>> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        for(int i = 0 ; i < banned_id.length; i++){
            banned_id[i] = banned_id[i].replace("*", ".");
        }
        boolean[] check = new boolean[user_id.length];
        dfs(user_id, banned_id, check, 0, banned_id.length);
        return set.size();
    }
    
    static void dfs(String[] user_id, String[] banned_id, boolean[] check, int d, int depth){
        if(d == depth){
            ArrayList<String> n = (ArrayList)ar.clone();
            Collections.sort(n);
            set.add(n);
            return;
        }
        
        
        Pattern pattern = Pattern.compile(banned_id[d]); 

        for(int i= 0 ; i < user_id.length; i++){
            Matcher matcher = pattern.matcher(user_id[i]);
            
            if(check[i] != true){
                if(matcher.matches()){
                    check[i] = true;
                    ar.add(user_id[i]);
                    dfs(user_id, banned_id, check, d+1, depth);
                    check[i] = false;
                    ar.remove(d);
                }
               
            }
        }
    }
}