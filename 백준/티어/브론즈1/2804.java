import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");

        String A = strs[0];
        String B = strs[1];

        int lenA = A.length();
        int lenB = B.length();
        char[][] chars = new char[lenB][lenA];
        int idx = 0;
        int i = 0;
        for (; i < lenA; i++) {
            char x = A.charAt(i);
            idx = B.indexOf(x);
            if (idx != -1) {
                break;
            }
        }

        for (int j = 0; j < lenA; j++) {
            chars[idx][j] = A.charAt(j);
        }

        for (int j = 0; j < lenB; j++) {
            chars[j][i] = B.charAt(j);
        }

        for (int b = 0; b < lenB; b++) {
            for (int a = 0; a < lenA; a++) {
                char c = chars[b][a];
                System.out.print(c >= 'A' && c <= 'Z' ? c : '.');
            }
            System.out.println();
        }


    }



}

