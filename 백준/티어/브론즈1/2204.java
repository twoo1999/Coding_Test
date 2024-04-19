import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        List<String> re = new ArrayList<>();
        while (true) {
            int cnt = Integer.parseInt(sc.nextLine());
            if (cnt == 0) {
                break;
            }

            String[] str = new String[cnt];
            for (int i = 0; i < cnt; i++) {
                str[i] = sc.nextLine();
            }
            int idx = 0;
            while (str.length != 1) {
                str = func(str, idx++);
            }
            re.add(str[0]);
        }

        for (int i = 0; i < re.size(); i++) {
            System.out.println(re.get(i));
        }

    }

    public static String[] func(String[] str, int n){
        int min = 100;
        List<String> re = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            String newStr = str[i].toLowerCase();
            if(str[i].length() < n+1){
                re = new ArrayList<>();
                re.add(str[i]);
                break;
            }
            int s = (int)newStr.charAt(n) - 'a';
            if (s < min) {
                re = new ArrayList<>();
                re.add(str[i]);
                min = s;
            } else if (s == min) {
                re.add(str[i]);
            }
        }
        return re.toArray(new String[re.size()]);
    }

}
