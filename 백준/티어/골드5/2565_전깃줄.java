import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] line = new int[n][2];

        for (int i = 0; i < n; i++) {
            line[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        }
        int max = 0;
        Arrays.sort(line, (x, y)->{
            if(x[0] != y[0]) return x[0] - y[0];
            else return x[1] - y[1];
        });

        int[] DP = new int[501];
        for (int i = 0; i < n; i++) {
            DP[i] = 1;

            for (int j = 0; j < i; j++) {
                if (line[i][1] > line[j][1]) {
                    DP[i] = Math.max(DP[i], DP[j] + 1);
                }
            }

            max = Math.max(max, DP[i]);
        }

        System.out.println(n - max);

    }

}