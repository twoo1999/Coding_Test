import java.util.*;
class Solution {
    static ArrayList<String[]> ar = new ArrayList<>();
    public String[] solution(String[][] t) {
        Queue<String> q = new LinkedList<>();
        boolean[] check = new boolean[t.length];
        String[] re = new String[10000];
        dfs(t, check, "ICN", re, 0);

        
        String[] ans = new String[]{};
        int max = 0;
        for(String[] a : ar){
            if(a.length > ans.length){
                ans = a;
            } else if(a.length == ans.length){
                if(compare(ans, a) > 0){
                    ans = a;
                }
            }
        }
        
        String[] arr = new String[ans.length+1];
        arr[0] = "ICN";
        for(int i = 0 ; i < ans.length; i++){
            arr[i+1] = ans[i];
        }
        return arr;
    }
    static int compare(String[] a, String[] b){
        for(int i = 0 ; i < a.length; i++){
            int re = a[i].compareTo(b[i]);
            if(re != 0){
                return re;
            }
        }
        
        return 0;
    }
    static void dfs(String[][] t, boolean[] check, String curr, String[] re, int cnt){

        
        ArrayList<String> a = new ArrayList<>();
        ArrayList<Integer> idx = new ArrayList<>();
        boolean c = false;
        for(int i = 0 ; i < t.length; i++){
            if(check[i] != true && t[i][0].equals(curr)){
                a.add(t[i][1]);
                idx.add(i);
                c = true;
            }
        }
        if(!c){
            ar.add(Arrays.copyOfRange(re, 0, cnt));
            return;
        }
        for(int i = 0 ; i < idx.size(); i++){
            check[idx.get(i)] = true;
            re[cnt] = a.get(i);
            dfs(t, check, a.get(i), re, cnt+1);
            check[idx.get(i)] = false;
        }
        
    }
}