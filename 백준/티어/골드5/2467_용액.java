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
        int s = 0;
        int e = 0;
        int start = 0;
        int end = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(start < end){
            int n1 = nums[start];
            int n2 = nums[end];
            int sum = n1 + n2;

            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                s = start;
                e = end;
            }

            if(sum > 0) end--;
            else if(sum < 0) start++;
            else break;
        }



        System.out.println(s + " " + e);
    }


}
