import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int n = input[0];
        int k = input[1];
        int[] kind = new int[n];
        int[] dp = new int[10000001];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            kind[i] = Integer.parseInt(br.readLine());
            dp[kind[i]] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if(i - kind[j] <= 0) continue;
                if(dp[i - kind[j]] == Integer.MAX_VALUE) continue;

                dp[i] = Math.min(dp[i - kind[j]]+1, dp[i]);
            }

        }

        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);

    }

}