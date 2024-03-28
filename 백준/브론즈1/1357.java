import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        System.out.println(rev(Integer.toString(rev(str[0])+rev(str[1]))));

    }

    public static int rev(String numStr) {
        StringBuffer sb = new StringBuffer(numStr);
        String reversedNumStr = sb.reverse().toString();
        return Integer.parseInt(reversedNumStr);
    }




}
