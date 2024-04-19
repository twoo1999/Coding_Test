import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int max = 0;

        int cnt = Integer.parseInt(sc.nextLine());

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
        int low = nums[0];
        for (int i = 1; i < cnt; i++) {
            int now = nums[i];
            int prev = nums[i - 1];

            if (now > prev) {
                int c = now-low;
                if (c > max) {
                    max = c;
                }
            } else {
                low = now;
            }
        }

        System.out.println(max);

    }





}

