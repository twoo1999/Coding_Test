import java.util.*;

class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int size = board.length;
        int[][][] dp = new int[size][size][2];

        for (int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                dp[i][j] = new int[]{Integer.MAX_VALUE-1000, Integer.MAX_VALUE-1000};
            }
        }
        dp[0][0] = new int[]{0, 0};
        int[][] dirs = {{0, 1}, {-1, 0}, {1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] pos = q.poll();
            for(int[] dir: dirs){
                int y = pos[0];
                int x = pos[1];
                int ny = y + dir[0];
                int nx = x + dir[1];

                if(ny >= size || ny < 0 || nx >= size || nx < 0) continue;
                if(board[ny][nx] == 1) continue;
                int costRow = dp[y][x][0];
                int costCol = dp[y][x][1];
                int cost;
                if(dir[0] == 0){ // 가로
                    if(costRow + 100 < costCol + 600) cost = costRow + 100;
                    else cost = costCol + 600;
                    if(cost < dp[ny][nx][0]){
                        dp[ny][nx][0] = cost;
                        q.add(new int[]{ny, nx});
                    }
                } else { // 세로
                    if(costRow + 600 < costCol + 100) cost = costRow + 600;
                    else cost = costCol + 100;
                    if(cost < dp[ny][nx][1]){
                        dp[ny][nx][1] = cost;
                        q.add(new int[]{ny, nx});
                    }
                }


            }
        }
        return Math.min(dp[size-1][size-1][0], dp[size-1][size-1][1]);
    }
}