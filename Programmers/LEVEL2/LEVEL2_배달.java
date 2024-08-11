import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0; 
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)->x[1]-y[1]);
        int[] dist = new int[N+1];
        
        for (int i = 1; i <= N; i++) {
            dist[i] = Integer.MAX_VALUE;
        }
        
        dist[1] = 0;
        boolean[] visisted = new boolean[N + 1];
        
        pq.add(new int[]{1, 0});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int currPoint = curr[0];
            int currCost = curr[1];
            for (int i = 0; i < road.length; i++) {
                int x = road[i][0];
                int y = road[i][1];
                int cost = road[i][2];
                int start;
                int end;
                if (currPoint == x) {
                    start = x;
                    end = y;
                } else if (currPoint == y) {
                    start = y;
                    end = x;
                } else {
                    continue;
                }
                if (!visisted[end]) {
                    if (dist[end] > currCost + cost) {
                        dist[end] = currCost + cost;
                        pq.add(new int[]{end, dist[end]});
                    }

                }
            }
            visisted[currPoint] = true;

        }


        for (int i : dist) {
            if (K >= i) {
                answer++;
            }
        }

        return answer-1;
    }
}