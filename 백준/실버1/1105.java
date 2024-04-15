import java.io.IOException;
import java.util.Scanner;

public class Main {
    static int count = 0;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.nextLine().split(" ");
        boolean flag = false;
        String L = nums[0];
        String R = nums[1];
        int re = 0;
        if (L.length() == R.length()) {
            for (int i = 0; i < L.length(); i++) {

                char l = L.charAt(i);
                char r = R.charAt(i);

                if (l == r) {
                    if (l == '8') {
                        re++;
                    }
                } else {
                    break;
                }
            }
        }else{
            re = 0;
        }



        System.out.println(re);



    }
}