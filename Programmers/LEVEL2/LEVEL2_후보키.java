import java.util.*;

class Solution {
    static ArrayList<Set<Integer>> set = new ArrayList<>();
    public int solution(String[][] relation) {
        int answer = 0;
        int col = relation[0].length;
        boolean[] check = new boolean[col];
        for(int i = 1 ; i <= col; i++){
            comb(relation, check, i, 0, 0);    
        }
        
        System.out.println(set);
        return set.size();
    }
    
    
    void comb(String[][] relation, boolean[] check, int cnt, int s, int depth){
        if(cnt == depth){
            Set<Integer> arr = new HashSet<>();
            int idx = 0;
            for(int i = 0 ;i < check.length; i++){
                if(check[i]) arr.add(i);
            }
            func(relation, arr);
            return;
        }
        
        
        for(int i = s ; i < check.length; i++){
            check[i] = true;
            comb(relation, check, cnt, i+1, depth+1);
            check[i] = false;
        }
    }
    
    void func(String[][] relation, Set<Integer> com){
        for(Set<Integer> s : set){
            if(com.containsAll(s)){
                return;
            }
        }
        
        Set<String> strset = new HashSet<>();
        for(String[] re : relation){
            StringBuilder sb = new StringBuilder("");
            for(int c : com){
                sb.append(re[c]);
                sb.append(".");
            }
            strset.add(sb.toString());
        }
        
        if(strset.size() == relation.length){
            set.add(com);
        }
        
        
    }
}