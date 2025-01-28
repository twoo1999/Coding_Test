import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = info[0];
        int K = info[1];
        int[][] items = new int[N][2];

        for (int i = 0; i < N; i++) {
            items[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        boolean[][] DP = new boolean[100001][N];
        int[] dp = new int[100001];
        int max = 0;


        for (int i = 0; i < N; i++) {
            int w = items[i][0];
            int v = items[i][1];
            if (dp[w] != 0) {
                DP[w][i] = true;
                dp[w] = v;
                max = Math.max(max, v);
            }

        }
        for (int k = 1; k <= K; k++) {

            for (int n = 0; n < N; n++) {
                int w = items[n][0];
                int v = items[n][1];
                if(k - w < 0) continue;
                if (dp[k] < dp[k - w] + v) {
                    if (DP[k - w][n] != true) {
                        max = Math.max(dp[k - w] + v, max);
                        dp[k] = dp[k-w] + v;
                        DP[k] = DP[k-w].clone();
                        DP[k][n] = true;
                    }

                }

            }
        }


        System.out.println(max);

    }

}