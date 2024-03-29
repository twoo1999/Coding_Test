import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int max = 0;
        int point = 0;
        int cnt = Integer.parseInt(sc.nextLine());
        String[] chs = new String[cnt];
        for (int i = 0; i < cnt; i++) {
            chs[i] = sc.nextLine();
        }
        StringBuilder sb = new StringBuilder();
        int KBS1idx = idx(chs, "KBS1");
        for (int i = 0; i < KBS1idx; i++) {
            sb.append('1');
            point++;
        }
        for (int i = 0; i < KBS1idx; i++) {

            chs = switchChs(chs, point);
            point--;
            sb.append('4');

        }

        int KBS2idx = idx(chs, "KBS2");
        for (int i = 0; i < KBS2idx; i++) {
            sb.append('1');
            point++;
        }

        for (int i = 0; i < KBS2idx-1; i++) {
            chs = switchChs(chs, point);
            point--;
            sb.append('4');
        }

        System.out.println(sb);


    }

    public static int idx(String[] chs, String ch) {
        for (int i = 0; i < chs.length; i++) {
            if (chs[i].equals(ch)) {
                return i;
            }
        }
        return -1;
    }

    public static String[] switchChs(String[] chs, int idx) {
        String[] newStrs = new String[chs.length];

        for (int i = 0; i < chs.length; i++) {
            newStrs[i] = chs[i];
        }

        String temp = newStrs[idx-1];
        newStrs[idx - 1] = newStrs[idx];
        newStrs[idx] = temp;

        return newStrs;
    }





}

