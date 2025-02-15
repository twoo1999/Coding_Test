
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int m = input[1];
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        ArrayList<String> ar = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] in = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int type = in[0];
            int a = in[1];
            int b = in[2];

            if (type == 0) {
                union(arr, a, b);
            } else {
                int p1 = find(arr, a);
                int p2 = find(arr, b);
                if (p1 == p2) {
                    ar.add("YES");
                } else {
                    ar.add("NO");
                }

            }
        }

        for (String s : ar) {
            System.out.println(s);
        }



    }

    static void union(int[] arr, int a, int b) {
        int p1 = find(arr, a);
        int p2 = find(arr, b);
        arr[p1] = p2;
    }
    static int find(int[] arr, int a){
        if(arr[a] == a){
            return a;
        }

        return arr[a] = find(arr, arr[a]);
    }
}