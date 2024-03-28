import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();

        int N = nums[0];
        int P = nums[1];

        List<Integer> list = new ArrayList<>();
        int remain = N;
        int cnt = 0;
        while (true) {
            int mul = remain * N;
            remain = mul % P;
            int idx = list.indexOf(remain);
            if (idx != -1) {
                System.out.println(cnt-idx);
                break;
            }
            list.add(remain);
            cnt++;
        }

    }


}
