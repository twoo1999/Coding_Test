import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        dfs(board, n, 0, 0, 1);
        System.out.println(ans);
    }

    static void dfs(int[][] board, int n, int dir, int y, int x) {
        if (y == n - 1 && x == n - 1) {
            ans++;
            return;
        }

        int[][] moves = {{0, 1}, {1, 0}, {1, 1}}; // 0:가로 1:세로 2:대각


        for (int i = 0; i < 3; i++) {
            int[] move = moves[i];
            int ny = y + move[0];
            int nx = x + move[1];
            if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;

            if(dir == 0) { // 가로 일 때
                if(i == 1) continue;

                if(i == 0){
                    if(board[ny][nx] != 1) dfs(board, n, 0, ny, nx);
                } else if(i == 2){
                    if (board[ny][nx] != 1 && board[y + 1][x] != 1 && board[y][x + 1] != 1) dfs(board, n, 2, ny, nx);
                }

            } else if(dir == 1){ // 세로일 때
                if(i == 0) continue;

                if(i == 1){
                    if(board[ny][nx] != 1) dfs(board, n, 1, ny, nx);
                } else if(i == 2){
                    if (board[ny][nx] != 1 && board[y + 1][x] != 1 && board[y][x + 1] != 1) dfs(board, n, 2, ny, nx);
                }

            } else if(dir == 2){
                if(i == 0){
                    if(board[ny][nx] != 1) dfs(board, n, 0, ny, nx);
                } else if(i == 1){
                    if(board[ny][nx] != 1) dfs(board, n, 1, ny, nx);
                } else {
                    if (board[ny][nx] != 1 && board[y + 1][x] != 1 && board[y][x + 1] != 1) dfs(board, n, 2, ny, nx);
                }
            }
        }

    }


}