import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = sc.nextInt();
        int[] re = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            int max = sc.nextInt();
            int min = 0;
            int temp = sc.nextInt();
            if (max < temp) {
                min = max;
                max = temp;
            }else{
                min = temp;
            }
            int mul = 1;
            while (true) {
                int c = max* mul;
                if (c % min == 0) {
                    break;
                }
                mul++;
            }
            re[i] = max*mul;


        }

        for (int i = 0; i < cnt; i++) {
            System.out.println(re[i]);
        }

    }

}

