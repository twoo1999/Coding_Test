import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int cnt;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cnt = 0;
        sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        hanoi(1, 2, 3, n);
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    static void hanoi(int from, int m, int to, int n) {
        if(n == 0) return;
        cnt++;
        hanoi(from, to, m, n - 1);
        sb.append(from + " " + to + "\n");
        hanoi(m, from, to, n - 1);
    }
}