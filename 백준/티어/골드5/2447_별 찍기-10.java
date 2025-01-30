import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ans = func(n);
        System.out.println(ans);
    }

    static String func(int n) {
        if (n == 3) {
            return "***\n* *\n***";
        } else{
            String f = func(n / 3);

            String[] strs = f.split("\n");
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n / 3; i++) {
                sb.append(strs[i].repeat(3));
                sb.append("\n");
            }
            String z = sb.toString();
            for (int i = 0; i < (n / 3); i++) {
                sb.append(strs[i]);
                sb.append(" ".repeat(n/3));
                sb.append(strs[i]);
                sb.append("\n");
            }
            sb.append(z);
            return sb.toString();
        }
    }

}
