import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        Arrays.sort(nums);

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = nums.length-1;

        int s = 0;
        int e = 0;
        while (start < end) {
            int sum = nums[start] + nums[end];

            if (Math.abs(sum) < min) {
                min = Math.abs(sum);

                s = nums[start];
                e = nums[end];
                if(sum == 0) break;

            }


            if(sum > 0) end--;
            else start++;

        }


        System.out.println(s + " " + e);
    }


}