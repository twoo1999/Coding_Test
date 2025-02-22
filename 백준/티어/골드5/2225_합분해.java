import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int K = input[1];

        long[][] DP = new long[K + 1][N + 1];

        for (int n = 0; n <= N; n++) {
            DP[1][n] = 1;
        }


        for (int k = 2; k <= K; k++) {
            for (int n = 0; n <= N; n++) {
                for (int i = 0; i <= n; i++) {
                    DP[k][n] += DP[k-1][i] % 1000000000;
                }
            }
        }
        System.out.println(DP[K][N]%1000000000);

    }

}