import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        int re=0;
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < cnt; i++) {
            strs.add(sc.nextLine());
        }
        strs.sort((x, y) -> x.length() - y.length());
        for (int i = 0; i < strs.size(); i++) {
            boolean flag = true;
            String origin = strs.get(i);

            for (int j = i + 1; j < strs.size(); j++) {
                if (origin.equals(strs.get(j).substring(0, origin.length()))) {
                    flag = false;
                    break;
                }

            }
            if (flag) {
                re++;
            }

        }
        System.out.println(re);



    }


}