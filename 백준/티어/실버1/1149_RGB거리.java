import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    static int[][] board;
    static int[][] DP;
    static int re = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        board = new int[cnt][3];
        DP = new int[cnt][3];
        for (int i = 0; i < cnt; i++) {
            String[] ns = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(ns[j]);
            }
        }


        DP[0][0] = board[0][0];
        DP[0][1] = board[0][1];
        DP[0][2] = board[0][2];

        System.out.println(Math.min(func(cnt-1, 0), Math.min(func(cnt-1, 1), func(cnt-1, 2))));


    }

    public static int func(int cnt, int c) {
        if (DP[cnt][c] == 0) {
            if (c == 0) {
                DP[cnt][0] = Math.min(func(cnt - 1, 1), func(cnt - 1, 2)) + board[cnt][0];
            } else if (c == 1) {
                DP[cnt][1] = Math.min(func(cnt - 1, 0), func(cnt - 1, 2)) + board[cnt][1];
            } else if (c == 2) {
                DP[cnt][2] = Math.min(func(cnt - 1, 1), func(cnt - 1, 0)) + board[cnt][2];
            }
        }

        return DP[cnt][c];
    }





}