import java.util.*;
class Solution {
    static int min;
    public int solution(int[][] board) {
        int answer = 0;
        min = Integer.MAX_VALUE;
        int n = board.length;
        boolean[][][] visited = new boolean[2][n][n];
        visited[0][0][0] = true;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] tv = {{-1, 0}, {0, 0}, {-1, 1}, {0, 1}}; // to Vertical
        int[][] th = {{0, -1}, {1, -1}, {0, 0}, {1, 0}}; // to Horizon
        Queue<int[]> q = new LinkedList<>(); // x, y, cnt, dim
        q.add(new int[]{0, 0, 0, 0});

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int x = info[0];
            int y = info[1];
            int cnt = info[2];
            int dim = info[3];

            if(cnt > min) continue;
            if (dim == 0) { // 가로
                if ((x == n - 1 || x + 1 == n - 1) && (y == n - 1)) {
                    min = Math.min(min, cnt);
                    continue;
                }
            } else {
                if ((x == n - 1) && (y == n - 1 || y + 1 == n - 1)) {
                    min = Math.min(min, cnt);
                    continue;
                }
            }

            for (int[] dir : dirs) {
                int nx = x + dir[1];
                int ny = y + dir[0];


                if (dim == 0) {
                    if(nx < 0 || nx >= n-1 || ny < 0 || ny >= n) continue;
                    if(board[ny][nx] == 1 || board[ny][nx+1] == 1) continue;
                } else{
                    if(nx < 0 || nx >= n || ny < 0 || ny >= n-1) continue;
                    if(board[ny][nx] == 1 || board[ny+1][nx] == 1) continue;
                }
                if (visited[dim][ny][nx] != true) {
                    visited[dim][ny][nx] = true;
                    q.add(new int[]{nx, ny, cnt + 1, dim});
                }
            }

            if (dim == 0) { // 가로 -> 세로 // toVertical
                for (int[] v : tv) {
                    int ny = y + v[0];
                    int nx = x + v[1];

                    if(nx < 0 || nx >= n || ny < 0 || ny >= n-1) continue;
                    if (visited[1][ny][nx] == true) continue;
                    if (v[0] == -1) {
                        if(board[y-1][x] == 1 || board[y-1][x+1] == 1) continue;
                    } else{
                        if(board[y+1][x] == 1 || board[y+1][x+1] == 1) continue;
                    }
                    visited[1][ny][nx] = true;
                    q.add(new int[]{nx, ny, cnt + 1, 1});
                }
            } else{ // 세로 -> 가로 // toHorizon
                for (int[] h : th) {
                    int ny = y + h[0];
                    int nx = x + h[1];

                    if(nx < 0 || nx >= n-1 || ny < 0 || ny >= n) continue;
                    if (visited[0][ny][nx] == true) continue;

                    if (h[1] == -1) {
                        if(board[y][x-1] == 1 || board[y+1][x-1] == 1) continue;
                    } else {
                        if(board[y][x+1] == 1 || board[y+1][x+1] == 1) continue;
                    }
                    visited[0][ny][nx] = true;
                    q.add(new int[]{nx, ny, cnt + 1, 0});
                }
            }

        }
        return min;
    }

    
}