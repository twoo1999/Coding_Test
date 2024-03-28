import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BigInteger money = new BigInteger(st.nextToken());
        BigInteger number = new BigInteger(st.nextToken());

        System.out.println(money.divide(number));
        System.out.println(money.mod(number));
    }
}