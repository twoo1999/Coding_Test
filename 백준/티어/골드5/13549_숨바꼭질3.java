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
        boolean[] isVisited = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        q.add(new int[]{N, 0});

        while (!q.isEmpty()) {
            int[] info = q.poll();

            int pos = info[0];
            int cnt = info[1];

            isVisited[pos] = true;
            if (pos == K) {
                ans = Math.min(ans, cnt);
            }
            for (int i = 0; i < 3; i++) {
                int np = pos;
                if (i == 0) {
                    np--;
                } else if (i == 1) {
                    np++;
                } else{
                    np *= 2;
                }

                if(np < 0 || np > 100000 || isVisited[np] == true) continue;

                if (i == 2) {
                    q.add(new int[]{np, cnt});
                } else{
                    q.add(new int[]{np, cnt+1});
                }

            }


        }

        System.out.println(ans);


    }

}