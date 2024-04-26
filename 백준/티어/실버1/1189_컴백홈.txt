import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
public class Main {
    static int re = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");

        int R = Integer.parseInt(nums[0]);
        int C = Integer.parseInt(nums[1]);
        int K = Integer.parseInt(nums[2]);
        String board[] = new String[R];
        boolean check[][] = new boolean[R][C];
        for(int i = 0 ; i< R; i++){
            Arrays.fill(check[i], false);
            board[i] = sc.nextLine();
        }
        check[R-1][0] = true;
        dfs(board, check, 1, R-1, 0, R,C, K);

        System.out.println(re);

    }

    public static void dfs(String[] board, boolean[][] check, int cnt, int row, int col, int R, int C, int K){
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        if(row == 0 && col == C-1){
            if(cnt == K){
                re++;
            }
            return;
        }

        for(int i = 0; i < 4; i++){
            int nxRow = row+dir[i][0];
            int nxCol = col+dir[i][1];
            if(nxRow >= 0 && nxRow < R && nxCol >= 0 && nxCol < C && !check[nxRow][nxCol] && board[nxRow].charAt(nxCol) != 'T'){
                check[nxRow][nxCol] = true;
                dfs(board, check, cnt+1, nxRow, nxCol, R, C, K);
                check[nxRow][nxCol] = false;
            }
        }





    }






}