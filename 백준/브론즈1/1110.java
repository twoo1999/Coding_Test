import java.io.*;
import java.util.*;

public class Main {
    public static String func(String num) {
        int intNum = Integer.parseInt(num);
        int left = intNum / 10;
        int right = intNum % 10;
        int sum = left + right;
        int sumRight = sum % 10;
        return String.valueOf(right*10+sumRight);

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String oriNum = br.readLine();
        int cnt = 0;
        String tempStr = oriNum;

        while (true) {
            tempStr = func(tempStr);
            cnt++;
            if(oriNum.equals(tempStr)){
                break;
            }
        }


        System.out.println(cnt);

    }



