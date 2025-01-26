import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String boardInfo = br.readLine();
        int[] bi = Arrays.stream(boardInfo.split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = bi[0];
        int n = bi[1];
        int[][] board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String row = br.readLine();
            board[i] = Arrays.stream(row.split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int ans = 0;

        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int total = 0;
        int c = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if(board[y][x] == 1) {
                    q.add(new int[]{y, x, 0});
                    c++;
                }
                if(board[y][x] != -1) total++;
            }
        }

        while (!q.isEmpty()) {
            int[] info = q.poll();

            int y = info[0];
            int x = info[1];
            int cnt = info[2];

            for (int[] move : moves) {
                int ny = y + move[0];
                int nx = x + move[1];

                if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
                if(board[ny][nx] != 0) continue;
                board[ny][nx] = 1;
                q.add(new int[]{ny, nx, cnt + 1});
                c++;
                ans = Math.max(ans, cnt + 1);

            }
        }

        System.out.println(total == c ? ans : -1);
    }
}