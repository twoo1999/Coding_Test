import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();
        int N = nums[0];
        int K = nums[1];

        int[] temps = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();
        int max = 0;
        for (int i = 0; i <= N-K; i++) {
            int sum = 0;
            for (int j = 0; j < K; j++) {
                sum += temps[i+j];
            }
            if (sum > max) {
                max =sum ;
            }

            if (i == 0) {
                max = sum;
            }
        }

        System.out.println(max);


    }






}
