import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int num = Integer.parseInt(sc.nextLine());
        long[] row = new long[num+1];
        row[0] = 0;
        row[1] = 1;
        for (int i = 2; i <= num; i++) {
            row[i] = row[i-1] + row[i-2];
        }

        System.out.println(row[num]);
    }

}

