import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();
        int p = num[0];
        int w = num[1];
        String str = sc.nextLine();
        String[] keypad = {" ", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int time = 0;
        for (int i = 0; i < keypad.length; i++) {
            int idx = keypad[i].indexOf(str.charAt(0));
            if (idx != -1) {
                time += p * (idx + 1);
                break;
            }
        }
        for (int i = 1; i < str.length(); i++) {
            char prev = str.charAt(i-1);
            char now = str.charAt(i);

            for (int j = 0; j < keypad.length; j++) {
                int pidx = keypad[j].indexOf(prev);
                int nidx = keypad[j].indexOf(now);
                if(now == ' '){
                    time += p;
                    break;
                }
                if(pidx != -1 && nidx != -1){
                    time += w + p*(nidx+1);
                    break;
                } else if (nidx != -1) {
                    time += p*(nidx+1);
                    break;
                }

            }
        }
        System.out.println(time);

    }
}

