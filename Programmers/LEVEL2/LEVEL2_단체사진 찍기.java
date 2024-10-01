import java.util.*;
class Solution {
    static int ans;
    public int solution(int n, String[] data) {
        int answer = 0;
        ans = 0;
        String chars = "ACFJMNRT";
        boolean[] check = new boolean[chars.length()];
        for (int i = 0; i < chars.length(); i++) {
            check[i] = false;
        }
        dfs(chars, "", check, 0, check.length, data);
        return ans;
    }
    static void dfs( String chars, String position, boolean[] check, int cnt, int depth, String[] data) {
        if (cnt == 8 ) {


            if(isPass(data, position)){
                ans++;
            }
            return;
        }
        for (int i = 0; i < 8; i++) {
            if(check[i] != true){
                check[i] = true;
                String n = position + chars.charAt(i);
                dfs(chars, n, check, cnt + 1, depth, data);
                check[i] =false;
            }

        }
    }

    static boolean isPass(String[] data, String position){
        boolean isPass = true;
        for (String condition : data) {
            int x = condition.charAt(0);
            int y = condition.charAt(2);
            char comp = condition.charAt(3);
            int num = condition.charAt(4)-'0';
            int xidx = position.indexOf(x);
            int yidx = position.indexOf(y);

            if (comp == '=') {
                if(Math.abs(xidx - yidx) != num+1) {
                    isPass = false;
                    break;
                }
            } else if (comp == '>') {
                if(!(Math.abs(xidx - yidx) > num+1)) {
                    isPass = false;
                    break;
                }
            } else if (comp == '<') {
                if (!(Math.abs(xidx - yidx) < num+1)) {
                    isPass = false;
                    break;
                }
            }
        }
        return isPass;
    }
}