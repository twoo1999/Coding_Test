import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int ans = Integer.MAX_VALUE;
        int N = info[0];
        int M = info[1];
        int[][] ladder = new int[N][2];
        int[][] snake = new int[M][2];
        boolean[] isVisited = new boolean[101];
        for (int i = 0; i < N; i++) {
            ladder[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < M; i++) {
            snake[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }


        PriorityQueue<int[]> q = new PriorityQueue<>((x, y)->{
            return x[1] - y[1];
        });

        q.add(new int[]{1, 0});
        isVisited[1] = true;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int n = pos[0];
            int cnt = pos[1];
            for (int dice = 1; dice <= 6; dice++) {
                int next = n + dice;
                if(next == 100){
                    ans = Math.min(cnt + 1, ans);
                    break;
                }
                if(!isVisited[next]) isVisited[next] = true;
                else continue;


                boolean c = false;

                for (int l = 0; l < N; l++) {
                    if (next == ladder[l][0]) {
                        if (!isVisited[ladder[l][1]]) {
                            isVisited[ladder[l][1]] = true;
                            q.add(new int[]{ladder[l][1], cnt + 1});
                        }
                        c = true;
                    }
                }

                for (int s = 0; s < M; s++) {
                    if(next == snake[s][0]) {
                        if (!isVisited[snake[s][1]]) {
                            isVisited[snake[s][1]] = true;
                            q.add(new int[]{snake[s][1], cnt + 1});
                        }
                        c = true;
                    }
                }
                if(!c) q.add(new int[]{next, cnt + 1});


            }

        }

        System.out.println(ans);
    }


}
