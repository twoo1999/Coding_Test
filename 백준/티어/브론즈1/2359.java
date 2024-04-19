import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        do{
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }
            String left;
            String right;
            int strLen = str.length();
            if (strLen % 2 == 0) {
                left = str.substring(0, strLen/2);
                right = reverse(str.substring(strLen / 2));
            }else{
                left = str.substring(0, strLen/2);
                right = reverse(str.substring(strLen / 2+1));
            }
            if (left.equals(right)) {
                sb.append("yes");
            } else{
                sb.append("no");
            }
            sb.append("\n");

        } while (true);
        System.out.println(sb);
    }

    public static String reverse(String string) {
        char[] newStr = new char[string.length()];
        int len = string.length();
        for (int i = 0; i < len; i++) {
            newStr[i] = string.charAt(len-1-i);
        }
        return new String(newStr);
    }

}