import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input1[0];
        int M = input1[1];

        int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int y = input2[0];
        int x = input2[1];
        int dir = input2[2];
        if(dir == 1) dir = 3;
        else if(dir == 3) dir = 1;
        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        board[y][x] = 2;
        int cnt = 1;
        int[][] moves = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while (true) {
            boolean isClean = false;
            for (int i = 1; i <= 4; i++) {
                int[] move = moves[(dir + i) % 4];
                int ny = y + move[0];
                int nx = x + move[1];

                if (ny >= N || ny < 0 || nx >= M || nx < 0) continue;
                if (board[ny][nx] >= 1) continue;

                cnt++;
                board[ny][nx] = 2;
                isClean = true;
                dir = (dir + i) % 4;
                y = ny;
                x = nx;
                break;
            }

            if (!isClean) {
                int ny = -1 * moves[dir][0] + y;
                int nx = -1 * moves[dir][1] + x;
                if (ny >= N || ny < 0 || nx >= M || nx < 0) break;
                if(board[ny][nx] == 1) break;

                y = ny;
                x = nx;
            }
        }

        System.out.println(cnt);
    }


}