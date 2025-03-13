import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dpmax = new int[3];
        int[] dpmin = new int[3];
        Arrays.fill(dpmin, Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if(i == 0){
                dpmax = input.clone();
                dpmin = input.clone();
            } else {
                dpmax = new int[]{Math.max(dpmax[0], dpmax[1]) + input[0], Math.max(dpmax[0], Math.max(dpmax[1], dpmax[2])) + input[1], Math.max(dpmax[1], dpmax[2]) + input[2]};
                dpmin = new int[]{Math.min(dpmin[0], dpmin[1]) + input[0], Math.min(dpmin[0], Math.min(dpmin[1], dpmin[2])) + input[1], Math.min(dpmin[1], dpmin[2]) + input[2]};
            }
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(dpmax[i], max);
            min = Math.min(dpmin[i], min);
        }


        System.out.println(max + " " +min);


    }

}