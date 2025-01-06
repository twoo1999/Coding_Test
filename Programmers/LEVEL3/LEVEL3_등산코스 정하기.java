import java.util.*;
class Solution {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = {};

        Set<Integer> sg = new HashSet<>();
        Set<Integer> ss = new HashSet<>();
        for (int g : gates) {
            sg.add(g);
        }
        for (int s : summits) {
            ss.add(s);
        }
        answer = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        for (int[] path : paths) {
            int x = path[0];
            int y = path[1];
            int cost = path[2];

            if (m.get(x) == null) {
                m.put(x, new HashMap<>());
            }

            m.get(x).put(y, cost);

            if (m.get(y) == null) {
                m.put(y, new HashMap<>());
            }

            m.get(y).put(x, cost);
        }

        int[] board = new int[n+1];
        Arrays.fill(board, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y)->{
            return x[1] - y[1];
        });
        for (int g : gates) {
            q.add(new int[]{g, 0});
        }

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int pos = info[0];
            int maxIntensity = info[1];

            if(maxIntensity > answer[1]) continue;
            if(m.get(pos) == null) continue;
            Set<Integer> s = m.get(pos).keySet();

            for(int i : s){
                int dis = m.get(pos).get(i);
                int max = dis > maxIntensity ? dis : maxIntensity;
                if (max < board[i]) {
                    board[i] = max;
                    if(ss.contains(i)){
                        if (answer[1] > max) {
                            answer[0] = i;
                            answer[1] = max;
                        } else if (answer[1] == max) {
                            if(i < answer[0]){
                                answer[0] = i;
                                answer[1] = max;
                            }
                        }
                        continue;
                    }
                    if(sg.contains(i)) continue;
                    q.add(new int[]{i, max});
                }
            }
        }

        return answer;
    }
}