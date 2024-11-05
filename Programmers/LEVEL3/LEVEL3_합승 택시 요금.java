import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[][] map = new int[n + 1][n + 1];

        int[][] costs = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(costs[i], 1000001);
            costs[i][i] = 0;
        }
        for (int[] fare : fares) {

            int start = fare[0];
            int end = fare[1];
            int cost = fare[2];

            costs[start][end] = cost;
            costs[end][start] = cost;

        }


        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, costs[s][i] + costs[i][a] + costs[i][b]);
        }
        return answer;
    }
}