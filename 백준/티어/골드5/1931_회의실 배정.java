import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][2];
        for (int i = 0; i < n; i++) {
            int[] time = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            times[i] = time;
        }

        Arrays.sort(times, (x, y)->{
            if (x[1] != y[1]) return x[1] - y[1];
            else return x[0] - y[0];
        });

        int cnt = 0;
        int last = 0;
        for (int[] time : times) {
            int start = time[0];
            int end = time[1];
            if (start >= last) {
                cnt++;
                if(last < end){
                    last = end;
                }
            }

        }

        System.out.println(cnt);
    }
}