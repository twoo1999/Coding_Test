import java.util.*;
class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        HashMap<Integer, Set<Integer>> win = new HashMap<>();
        HashMap<Integer, Set<Integer>> lose = new HashMap<>();

        for (int[] r : results) {
            int winner = r[0];
            int loser = r[1];

            if (win.get(winner) == null) {
                Set<Integer> s = new HashSet<>();
                win.put(winner, s);
            }
            win.get(winner).add(loser);

            if (lose.get(loser) == null) {
                Set<Integer> s = new HashSet<>();
                lose.put(loser, s);
            }
            lose.get(loser).add(winner);
        }

        for (int i = 1; i <= n; i++) {
            Set<Integer> w = win.get(i);
            if(w == null) continue;
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                Set<Integer> ww = win.get(j);
                if(ww == null) continue;
                if(ww.contains(i)){
                    ww.addAll(w);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            Set<Integer> l = lose.get(i);
            if(l == null) continue;

            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                Set<Integer> ll = lose.get(j);
                if(ll == null) continue;
                if (ll.contains(i)) {
                    ll.addAll(l);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            Set<Integer> w = win.get(i);
            Set<Integer> l = lose.get(i);
            int sum = (w == null ? 0 : w.size()) + (l == null ? 0 : l.size());

            if (sum == n - 1) answer++;


        }
        return answer;
    }
}