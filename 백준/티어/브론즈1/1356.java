import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] nums = Arrays.stream(str.chars().toArray()).map(x->x-48).toArray();

        int len = nums.length;
        if (len == 1) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < len; i++) {
            if (leftMul(nums, i) == rightMul(nums, i)) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");


    }

    public static int leftMul(int[] nums, int n) {
        int sum = 1;
        for (int i = 0; i < n; i++) {
            sum *= nums[i];
        }
        return sum;
    }

    public static int rightMul(int[] nums, int n) {
        int sum = 1;
        for (int i = n; i < nums.length; i++) {
            sum *= nums[i];
        }
        return sum;
    }



}
