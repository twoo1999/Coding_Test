import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int M = line[0];
        int N = line[1];
        int H = line[2];
        int[][][] board = new int[H][N][M];
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                board[h][n] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
        }

        Queue<int[]> q = new LinkedList<>();
        int[][] moves = {{0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}, {1, 0, 0}, {-1, 0, 0}};
        int ripe = 0;
        int total = 0;
        int max = 0;

        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if(board[h][n][m] == 1){
                        ripe++;
                        total++;
                        q.add(new int[]{h, n, m, 0});
                    } else if (board[h][n][m] == 0) {
                        total++;
                    }
                }
            }
        }

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int z = info[0];
            int y = info[1];
            int x = info[2];
            int cnt = info[3];

            for (int[] move : moves) {
                int nz = z + move[0];
                int ny = y + move[1];
                int nx = x + move[2];

                if(nz >= H || nz < 0 || ny >= N || ny < 0 || nx >= M || nx < 0) continue;
                if(board[nz][ny][nx] == 1 || board[nz][ny][nx] == -1) continue;

                board[nz][ny][nx] = 1;
                q.add(new int[]{nz, ny, nx, cnt + 1});

                ripe++;
                max = Math.max(max, cnt + 1);

            }
        }
        System.out.println(total == ripe ? max : -1);
    }
}