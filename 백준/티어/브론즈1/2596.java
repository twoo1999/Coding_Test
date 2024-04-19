import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        String[] chars = {"000000", "001111", "010011", "011100", "100110", "101001", "110101", "111010"};
        String str = sc.nextLine();
        List<Character> re = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            String subString = str.substring(i*6, (i+1)*6);

            for (int j = 0; j < chars.length; j++) {
                int dif = func(chars[j], subString);
                if (dif <= 1) {
                    re.add((char)(j + (int)'A'));
                    break;
                }

                if (j == chars.length-1) {
                    System.out.println(i+1);
                    return;
                }
            }
        }

        for (int i = 0; i < re.size(); i++) {
            System.out.print(re.get(i));
        }
    }



    public static int func(String pass, String str) {
        int dif = 0;
        for (int i = 0; i < 6; i++) {
            if (pass.charAt(i) != str.charAt(i)) {
                dif++;
            }
        }

        return dif;
    }
}
