import java.util.*;

class Solution {
    static ArrayList<String> ar = new ArrayList<>();
    static int max = 0;
    static Set<String> s;
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        ArrayList<String> ans = new ArrayList<>();
        for(int c: course){
            s = new HashSet<>();
            ArrayList<String> ar = new ArrayList<>();
            int max = 0;
            for(String order: orders){
                boolean[] check = new boolean[order.length()];
                comb(check, order.toCharArray(), 0, c, 0);    
            }
            for(String menus : s){
                int n = count(orders, menus);
                if(n >= max && n > 1){
                    if(n != max){
                        max = n;
                        ar = new ArrayList<>();
                    }
                    ar.add(menus);
                }
            }
            for(String a : ar){
                ans.add(a);
            }
        }
        Collections.sort(ans);
        return ans.toArray(new String[ans.size()]);
    }
    
    public int count(String[] orders, String menus){
        int ans = 0;
        int len = menus.length();
        for(String order: orders){
            int cnt = 0;
            for(int i = 0 ; i < len; i++){
                if(order.contains(Character.toString(menus.charAt(i)))){
                    cnt++;
                }    
            }
            if(cnt == len){
                ans++;
            }
        }
        return ans;
    }
    
    public void comb(boolean[] check, char[] list, int start, int cnt, int depth){
        if(depth == cnt){
            String[] str = new String[cnt];
            char[] chs = new char[cnt];
            int idx = 0;
            for(int i = 0 ; i < list.length; i++){
                if(check[i]){
                    chs[idx++] = list[i];
                }
            }
            Arrays.sort(chs);
            s.add(new String(chs));
            return;
        }
        
        for(int i = start ; i < list.length; i++){
            if(check[i] != true){
                check[i] = true;
                comb(check, list, i+1, cnt, depth+1);
                check[i] = false;
            }
            
        }
    }
    
    
}