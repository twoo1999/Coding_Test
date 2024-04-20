import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int[][] DP;
    static int re = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        DP = new int[num+1][3];

        DP[1][0] = DP[1][1] = DP[1][2] = 1;
        for (int i = 2; i <= num; i++) {
            DP[i][0] = (DP[i - 1][0] + DP[i - 1][1] + DP[i - 1][2])%9901;
            DP[i][1] = (DP[i - 1][0] + DP[i - 1][2]) % 9901;
            DP[i][2] = (DP[i - 1][0] + DP[i - 1][1]) % 9901 ;
        }


        System.out.println((DP[num][0] + DP[num][1] + DP[num][2])%9901);
    }






}