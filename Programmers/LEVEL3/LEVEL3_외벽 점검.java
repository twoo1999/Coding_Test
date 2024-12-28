import java.util.*;
class Solution {
    static int ans;
    public int solution(int n, int[] weak, int[] dist) {
        int answer = 0;

        ans = Integer.MAX_VALUE;
        boolean[] check = new boolean[dist.length];

        int[] w = new int[weak.length * 2];
        for (int i = 0; i < weak.length; i++) {
            w[i] = weak[i];
        }
        for (int i = 0; i < weak.length; i++) {
            w[i+weak.length] = weak[i] + n;
        }

        Arrays.sort(dist);
        int[] d = new int[dist.length];
        for (int i = 0; i < dist.length; i++) {
            d[dist.length - 1 - i] = dist[i];
        }
        dfs(n, w, d, new boolean[weak.length], 0);

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static void dfs(int n, int[] weak, int[] dist, boolean[] check, int cnt) {
        if (isFull(check)) {
            ans = Math.min(ans, cnt);
            return;
        }
        if (cnt >= dist.length) {
            return;
        }
        for (int i = 0; i < check.length; i++) {
            if(check[i] == true) continue;
            check[i] = true;
            Queue<Integer> st = new LinkedList<>();
            int idx = i;
            while(dist[cnt] + weak[i] >= weak[++idx] && check[idx % check.length] != true){
                st.add(idx);
                check[idx%check.length] = true;
            }
            dfs(n, weak, dist, check, cnt+1);

            check[i] = false;
            while (!st.isEmpty()) {
                check[st.poll()%check.length] = false;
            }
        }
    }
    static boolean isFull(boolean[] check) {
        for (int i = 0; i < check.length; i++) {
            if (check[i] == false) {
                return false;
            }
        }

        return true;
    }
}