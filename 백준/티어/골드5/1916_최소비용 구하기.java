import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());
        int[][] board = new int[cityNum + 1][cityNum + 1];

        for (int i = 0; i <= cityNum; i++) {
            Arrays.fill(board[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < busNum; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int start = input[0];
            int end = input[1];
            int cost = input[2];
            board[start][end] = Math.min(board[start][end], cost);
        }

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int start = input[0];
        int end = input[1];

        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y)->{
            return x[1] - y[1];
        });
        int[] answer = new int[cityNum + 1];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[start] = 0;

        for (int i = 1; i <= cityNum; i++) {
            if(board[start][i] != Integer.MAX_VALUE){
                pq.add(new int[]{i, board[start][i]});
                answer[i] = board[start][i];
            }
        }

        while (!pq.isEmpty()) {
            int[] info = pq.poll();
            int city = info[0];
            int cost = info[1];

            for (int i = 1; i <= cityNum; i++) {
                if (board[city][i] == Integer.MAX_VALUE) continue;
                if(i == city) continue;
                if(board[city][i] + cost < answer[i]){
                    answer[i] = board[city][i] + cost;
                    pq.add(new int[]{i, board[city][i] + cost});
                }

            }
        }
        System.out.println(answer[end]);
    }
}