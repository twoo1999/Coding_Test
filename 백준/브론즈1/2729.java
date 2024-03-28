import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int cnt = Integer.parseInt(sc.nextLine());
        String[] re = new String[cnt];
        for(int i = 0 ; i < cnt ; i++){
            String[] bins = sc.nextLine().split(" ");

            StringBuffer sbx = new StringBuffer(bins[0]);
            StringBuffer sby = new StringBuffer(bins[1]);
            String l, s;
            int max, min;
            if (sbx.length() > sby.length()) {
                l = sbx.reverse().toString();
                s = sby.reverse().toString();
            } else {
                l = sby.reverse().toString();
                s = sbx.reverse().toString();
            }

            max = l.length();
            min = s.length();
            StringBuilder sb = new StringBuilder();
            int flag = 0;
            for (int j = 0; j < max; j++) {
                int sum = (int) l.charAt(j) - (int) '0' + (min > j ? (int) s.charAt(j) - (int) '0' : 0) + flag;
                if (sum == 0) {
                    sb.append('0');
                    flag = 0;
                } else if (sum == 1) {
                    sb.append('1');
                    flag = 0;
                } else if (sum == 2) {
                    sb.append('0');
                    flag = 1;
                } else if (sum == 3) {
                    sb.append('1');
                    flag = 1;
                }
            }

            if(flag == 1){
                sb.append('1');
            }

            re[i] = sb.reverse().toString();


        }


        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < re[i].length(); j++) {
                if (re[i].charAt(j) == '1') {
                    System.out.println(re[i].substring(j));
                    break;
                }
                if (j == re[i].length() - 1) {
                    System.out.println('0');

                }
            }
        }
    }

}

