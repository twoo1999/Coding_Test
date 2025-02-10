import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static boolean isFront;
    static int start;
    static int end;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {

            String cmd = br.readLine();
            int l = Integer.parseInt(br.readLine());
            String[] nums = br.readLine().split(",");
            nums[0] = nums[0].substring(1);
            nums[nums.length -1] = nums[nums.length-1].substring(0, nums[nums.length-1].length()-1);

            isFront = true;
            start = 0;
            end = nums.length-1;
            cnt = l;
            Deque<Integer> d = new ArrayDeque<>();
            for (int j = 0; j < l; j++) {
                d.add(Integer.parseInt(nums[j]));
            }
            boolean f = false;
            for(char c : cmd.toCharArray()) {
                if(c == 'R') R();
                else {
                    if (cnt != 0) {
                        D();
                    } else {
                        answer.add("error");
                        f = true;
                        break;
                    }

                }
            }
            if (!f) {
                ArrayList<String> a = new ArrayList<>();
                for (int idx = start; idx <= end; idx++) {
                    a.add(nums[idx]);
                }

                if(isFront) answer.add("[" + String.join(",", a) + "]");
                else {
                    Collections.reverse(a);
                    answer.add("[" + String.join(",", a) + "]");
                }

            }
        }

        for (String a : answer) {
            System.out.println(a);
        }
    }

    static void R() {
        isFront = !isFront;
    }
    static void D(){
        if(isFront) start++;
        else end--;
        cnt--;
    }

}