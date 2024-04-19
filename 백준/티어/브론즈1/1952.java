import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int re = 0;
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] dirs = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        int dir = 0;
        boolean[][] board = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = false;
            }
        }
        int x = 0;
        int y = 0;
        board[x][y] = true;
        while (true) {
            int xtemp = x + dirs[dir][1];
            int ytemp = y + dirs[dir][0];
            if(xtemp >= col || xtemp < 0 || ytemp >= row || ytemp < 0){
                dir++;
                dir %= 4;
                int xx = x + dirs[dir][1];
                int yy = y + dirs[dir][0];
                if(board[yy][xx]){
                    break;
                }
                re++;
            }
            else if(board[ytemp][xtemp]){
                dir++;

                dir = dir%4;
                int xx = x + dirs[dir][1];
                int yy = y + dirs[dir][0];
                if(board[yy][xx]){
                    break;
                }
                re++;
            }
            else{
                x = xtemp;
                y = ytemp;
                board[y][x] = true;
            }

        }

        System.out.println(re);

    }
    public static void print(boolean[][] b, int row, int col){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(" " + b[i][j]);
            }
            System.out.println();
        }
    }
}

