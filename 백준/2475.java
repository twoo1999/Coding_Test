import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(st.nextToken());
            total += Math.pow(num, 2);
        }

        System.out.println(total%10);
    }
}