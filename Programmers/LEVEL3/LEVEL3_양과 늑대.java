import java.util.*;
class Solution {
    static int max = 0;
    public int solution(int[] info, int[][] edges) {
        int answer = 0;

        boolean[] check = new boolean[info.length];

        dfs(info, edges, 0, 0, check, 0);

        answer = max;


        return answer;
    }

    static void dfs(int[] info, int[][] edges, int w, int s, boolean[] check, int idx) {
        check[idx] = true;

        if(info[idx] == 0) s++;
        else w++;

        if(s <= w) return;

        max = Math.max(max, s);
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];

            if (check[parent] == true && check[child] == false) {
                boolean[] nc = check.clone();
                dfs(info, edges, w, s, nc, child);
            }
        }

    }
}