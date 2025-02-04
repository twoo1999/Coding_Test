import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = in[0];
        int M = in[1];
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        min = Integer.MAX_VALUE;
        ArrayList<int[]> store = new ArrayList<>();
        ArrayList<int[]> home = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 1) home.add(new int[]{i, j});
                else if(board[i][j] == 2) store.add(new int[]{i, j});
            }
        }
        int[] minDis = new int[home.size()];
        Arrays.fill(minDis, Integer.MAX_VALUE);

        comb(home, store, new boolean[store.size()], 0, store.size(), M);


        System.out.println(min);
    }

    static void comb(ArrayList<int[]> home, ArrayList<int[]> store, boolean[] visited, int start, int n, int r) {
        if(r == 0){
            int[] minDis = new int[home.size()];
            Arrays.fill(minDis, Integer.MAX_VALUE);

            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == true) {
                    int[] sinfo = store.get(i);
                    int sy = sinfo[0];
                    int sx = sinfo[1];
                    for (int j = 0; j < home.size(); j++) {
                        int[] hinfo = home.get(j);
                        int hy = hinfo[0];
                        int hx = hinfo[1];
                        minDis[j] = Math.min(minDis[j], Math.abs(sy - hy) + Math.abs(sx - hx));
                    }
                }
            }
            int total = 0;
            for (int i = 0; i < minDis.length; i++) {
                total += minDis[i];
            }

            min = Math.min(total, min);
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            comb(home, store, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

}