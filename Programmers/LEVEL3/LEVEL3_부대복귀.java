import java.util.*;
class Solution {
    static int min;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        answer = new int[sources.length];
        HashMap<Integer, List> map = new HashMap<>();
        int[] path = new int[n + 1];

        Arrays.fill(path, Integer.MAX_VALUE);
        path[destination] = 0;
        for (int[] road : roads) {
            int s = road[0];
            int e = road[1];
            if(map.get(s) == null){
                List<Integer> ar = new ArrayList<>();
                ar.add(e);
                map.put(s, ar);
            } else{
                map.get(s).add(e);
            }

            if(map.get(e) == null){
                List<Integer> ar = new ArrayList<>();
                ar.add(s);
                map.put(e, ar);
            } else{
                map.get(e).add(s);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{destination, 0});

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int pos = info[0];
            int cost = info[1];

            List<Integer> ar = map.get(pos);
            if(ar == null) continue;

            for (int next : ar) {
                if (path[next] > cost + 1) {
                    path[next] = cost + 1;
                    q.add(new int[]{next, cost + 1});
                }
            }
        }

        for (int i = 0; i < sources.length; i++) {
            int s = sources[i];
            answer[i] = path[s] == Integer.MAX_VALUE ? -1 : path[s];
        }
        return answer;
    }

}