import java.util.*;
class Solution {
    static ArrayList<int[]> ar = new ArrayList<>();
    static int sum = 0;
    public int solution(int n) {
        int answer = 0;
        dfs(0, n);
        return sum;
    }
    static void dfs(int cnt, int depth) {
        if (cnt == depth) {
            sum++;
            return;
        }

        for (int i = 0; i < depth; i++) {
            if(ar.isEmpty()){
                int[] a = new int[]{cnt, i};
                ar.add(a);
                dfs(cnt + 1, depth);
                ar.remove(a);
                continue;
            }
            boolean check = false;
            for (int[] pos : ar) {
                if(pos[1] == i) {// x
                    check = true;
                    break;
                }

                if (cnt - pos[0] == Math.abs(i - pos[1])) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                int[] a = new int[]{cnt, i};
                ar.add(a);
                dfs(cnt + 1, depth);
                ar.remove(a);
            }
        }
    }
}