import java.util.*;
class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        int rows = maps.length;
        int cols = maps[0].length();
        int[][] DP = new int[rows][cols];
        boolean[][] check = new boolean[rows][cols];
        int[] startPoint = {0, 0};
        int[] leverPoint = {0, 0};
        int[] exitPoint = {0, 0};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(maps[i].charAt(j) == 'S') startPoint = new int[]{i, j};
                else if (maps[i].charAt(j) == 'L') leverPoint = new int[]{i, j};
                else if (maps[i].charAt(j) == 'E') exitPoint = new int[]{i, j};
            }
        }

        // y x cost
        Queue<int[]> q = new LinkedList<>();
        q.add(startPoint);
        check[startPoint[0]][startPoint[1]] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[1];
            int y = curr[0];
            if(y == leverPoint[0] && x == leverPoint[1]){
                answer += DP[y][x];
                break;
            }
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int[] dir : dirs) {
                int nextx = x + dir[1];
                int nexty = y + dir[0];

                if(nextx >= cols || nextx < 0 || nexty >= rows || nexty < 0) continue;
                if(check[nexty][nextx] == true) continue;
                if(maps[nexty].charAt(nextx) == 'X') continue;
                if(DP[nexty][nextx] != 0 && DP[nexty][nextx] < DP[y][x] + 1) continue;

                check[nexty][nextx] = true;
                DP[nexty][nextx] = DP[y][x] + 1;
                q.add(new int[]{nexty, nextx});


            }

        }
        if (DP[leverPoint[0]][leverPoint[1]] == 0) {
            return -1;
        }

        DP = new int[rows][cols];
        check = new boolean[rows][cols];

        q = new LinkedList<>();
        q.add(leverPoint);
        check[leverPoint[0]][leverPoint[1]] = true;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[1];
            int y = curr[0];
            if(y == exitPoint[0] && x == exitPoint[1]){
                answer += DP[y][x];
                break;
            }
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

            for (int[] dir : dirs) {
                int nextx = x + dir[1];
                int nexty = y + dir[0];

                if(nextx >= cols || nextx < 0 || nexty >= rows || nexty < 0) continue;
                if(check[nexty][nextx] == true) continue;
                if(maps[nexty].charAt(nextx) == 'X') continue;
                if(DP[nexty][nextx] != 0 && DP[nexty][nextx] < DP[y][x] + 1) continue;
                check[nexty][nextx] = true;
                DP[nexty][nextx] = DP[y][x] + 1;
                q.add(new int[]{nexty, nextx});


            }

        }

        if (DP[exitPoint[0]][exitPoint[1]] == 0) {
            return -1;
        }

        return answer;
    }
   
}