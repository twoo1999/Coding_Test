import java.util.*;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int nArea = 0;
        int maxArea = 0;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                if(picture[y][x] == 0) continue;
                nArea++;
                Queue<int[]> q = new LinkedList<>();

                q.add(new int[]{y, x});
                int color = picture[y][x];
                picture[y][x] = 0;
                int cnt = 1;
                while (!q.isEmpty()) {
                    int[] pos = q.poll();
                    for (int[] dir : dirs) {
                        int ny = pos[0] + dir[0];
                        int nx = pos[1] + dir[1];

                        if(ny >= m || ny < 0 || nx >= n || nx < 0) continue;
                        if(picture[ny][nx] != color) continue;

                        q.add(new int[]{ny, nx});
                        picture[ny][nx] = 0;
                        cnt++;
                    }
                }

                if(cnt > maxArea) maxArea = cnt;

            }
        }
        return new int[]{nArea, maxArea};
    }
}