import java.util.*;
class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(String name) {
        int[] verticalCnt = new int[name.length()];

        boolean[] check = new boolean[name.length()];
        for (int i = 0; i < name.length(); i++) {
            int diff = name.charAt(i) - 'A';
            verticalCnt[i] = Math.min(diff, 'Z' - name.charAt(i)+1);
        }

        int n = 0;
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) != 'A'){
                n++;
            }
        }

        int cnt = 0;
        int move = 0;
        if (name.charAt(0) != 'A') {
            check[0] = true;
            move += verticalCnt[0];
            cnt++;
        }
        int cursor = 0;
        dfs(name, check, verticalCnt, cursor, n, cnt, move);
        return min;
    }
    static public void dfs(String name, boolean[] check, int[] verticalCnt, int cursor, int n, int cnt, int move) {
        if (cnt == n) {
            if (move < min) {
                min = move;
            }
            return;
        }


        for (int i = 1; i < name.length(); i++) {
            int next = cursor -i < 0 ? cursor-i + name.length() : cursor-i;
            if (name.charAt(next) != 'A' && check[next] != true) {
                check[next] = true;
                dfs(name, check, verticalCnt, next, n, cnt+1, move+i+verticalCnt[next]);
                check[next] = false;
                break;
            }
        }
        for (int i = 1; i < name.length(); i++) {
            int next = (cursor+i)%name.length();
            if (name.charAt(next) != 'A' && check[next] != true) {
                check[next] = true;
                dfs(name, check, verticalCnt, next, n, cnt+1, move+i+verticalCnt[next]);
                check[next] = false;
                break;
            }
        }
    }
}