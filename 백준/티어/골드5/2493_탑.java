import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] ans = new int[input.length];
        Stack<int[]> s = new Stack<>();

        for (int i = 0; i < input.length; i++) {
            if(s.isEmpty()){
                ans[i] = 0;
                s.push(new int[]{i+1, input[i]});
                continue;
            }

            while (!s.isEmpty()) {
                if (s.peek()[1] >= input[i]) {
                    ans[i] = s.peek()[0];
                    s.push(new int[]{i+1, input[i]});
                    break;
                } else {
                    s.pop();
                }
            }

            if(s.isEmpty()) {
                ans[i] = 0;
                s.push(new int[]{i+1, input[i]});
            }
        }

        String[] a = Arrays.stream(ans).mapToObj(String::valueOf).toArray(String[]::new);
        System.out.println(String.join(" ", a));


    }

}