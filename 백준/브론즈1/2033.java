import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int n = Integer.parseInt(str);
        int cnt = 0;
        String right = "";
        while (n != 0) {
            n /= 10;
            cnt++;
        }


        while(str.length() != 1) {
            int x = (int)str.charAt(str.length()-1) - (int)'0';
            if (x >= 5) {
                String sub = str.substring(0, str.length()-1);
                int num = Integer.parseInt(sub) + 1;
                right = right + "0";
                str = String.valueOf(num);
            }else {
                String sub = str.substring(0, str.length()-1);
                int num = Integer.parseInt(sub);
                right += "0";
                str = String.valueOf(num);
            }
        }
        System.out.println(str+ right);
    }
}

