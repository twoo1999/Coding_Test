import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int right = 2;
    static int left = 6;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int n = 4;
        int saw = 8;
        int[][] circles = new int[n][saw];
        int[] s = new int[n];

        for (int i = 0; i < n; i++) {
            circles[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int k = Integer.parseInt(br.readLine());
        int[][] cmds = new int[k][2];
        for (int i = 0; i < k; i++) {
            cmds[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0 ; i < k; i++) {
            int[] cmd = cmds[i];
            int circle = cmd[0] - 1;
            int dir = cmd[1];
            int[] ns = s.clone();
            if (dir == 1) {
                ns[circle] = (s[circle] - 1);
                if(ns[circle] < 0) ns[circle] += 8;
                rotateRight(circles, s, circle, dir, ns);
                rotateLeft(circles, s, circle, dir, ns);
            } else {
                ns[circle] = (s[circle] + 1) % 8;
                rotateRight(circles, s, circle, dir, ns);
                rotateLeft(circles, s, circle, dir, ns);
            }
            s = ns;


        }
        for (int i = 0; i < n; i++) {
            if(circles[i][s[i]] == 1){
                answer += Math.pow(2, i);
            }

        }
        System.out.println(answer);

    }

    static void rotateRight(int[][] circles, int[] s, int n, int dir, int[] ns) {
        if (n == 3) {
            return;
        }

        int rightPoint = circles[n][(s[n] + right) % 8];
        int leftPoint = circles[n+1][(s[n+1] + left) % 8];

        if (rightPoint != leftPoint) {
            if (dir == 1) {
                ns[n+1] = (s[n+1] + 1) % 8;
                rotateRight(circles, s, n + 1, -1, ns);
            } else {
                ns[n+1] = (s[n+1] - 1);
                if(ns[n+1] < 0) ns[n+1]+=8;
                rotateRight(circles, s, n + 1, 1, ns);
            }

        }
    }
    static void rotateLeft(int[][] circles, int[] s, int n, int dir, int[] ns) {
        if (n == 0) {
            return;
        }

        int leftPoint = circles[n][(s[n] + left) % 8];
        int rightPoint = circles[n-1][(s[n-1] + right) % 8];

        if (rightPoint != leftPoint) {
            if (dir == 1) {
                ns[n-1] = (s[n-1] + 1) % 8;
                rotateLeft(circles, s, n - 1, -1, ns);
            } else {
                ns[n-1] = (s[n-1] - 1);
                if(ns[n-1] < 0) ns[n-1]+=8;
                rotateLeft(circles, s, n - 1, 1, ns);
            }

        }
    }

}