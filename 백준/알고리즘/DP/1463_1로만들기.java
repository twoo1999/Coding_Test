import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int[] DP;
    static int re = 0;
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        int x = 1;
        DP = new int[num + 1];
        DP[0] = DP[1] = 0;
        for (int i = 2; i <= num; i++) {
            if (i % 6 == 0) {
                DP[i] = Math.min(DP[i-1], Math.min(DP[i/2], DP[i/3])) + 1;
            } else if (i % 2 == 0) {
                DP[i] = Math.min(DP[i-1], DP[i/2]) + 1;
            } else if (i % 3 == 0) {
                DP[i] = Math.min(DP[i-1], DP[i/3]) + 1;
            } else {
                DP[i] = DP[i-1] + 1;
            }
        }

        System.out.println(DP[num]);
    }






}