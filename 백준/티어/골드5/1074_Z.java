import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int r = input[1];
        int c = input[2];
        func(N, r, c, 0, 0, 0);
        System.out.println(ans);
    }
    static void func(int n, int r, int c, int y, int x, int cnt){
        if (n == 1) {
            int[][] moves = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
            for (int i = 0 ; i < 4; i++) {
                int[] move = moves[i];
                int ny = y + move[0];
                int nx = x + move[1];

                if(ny == r && nx == c){
                    ans = cnt + i;
                }
            }
            return;
        }
        n--;
        int m = (int)Math.pow(2, n);
        int midY = y + m - 1;
        int midX = x + m - 1;
        int plus = m * m ;
        if(r <= midY && c <= midX){
            func(n, r, c, y, x, cnt);
        } else if(r <= midY && c > midX) {
            func(n, r, c, y, x + m, cnt + plus);
        } else if(r > midY && c <= midX) {
            func(n, r, c, y + m, x, cnt + plus*2);
        } else if (r > midY && c > midX) {
            func(n, r, c, y + m, x + m, cnt + plus*3);
        }
    }

}