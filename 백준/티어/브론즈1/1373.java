import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String binNum = br.readLine();

        StringBuilder sb = new StringBuilder();

        int binLen = binNum.length();
        for (int i = binLen; i >0; i -= 3) {
            int start = i -3;
            if (start < 0) {
                start = 0;
            }
            String part = binNum.substring(start, i);
            switch (Integer.parseInt(part)) {
                case(0):
                    sb.append(0);
                    break;
                case(1):
                    sb.append(1);
                    break;
                case (10):
                    sb.append(2);
                    break;
                case (11):
                    sb.append(3);
                    break;
                case (100):
                    sb.append(4);
                    break;
                case (101):
                    sb.append(5);
                    break;
                case (110):
                    sb.append(6);
                    break;
                case (111):
                    sb.append(7);
                    break;
            }
        }
        System.out.println(sb.reverse());

    }
}

