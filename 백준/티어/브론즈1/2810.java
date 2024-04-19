import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());

        String seat = sc.nextLine();
        int c = 0;
        for (int i = 0; i < cnt; i++) {
            char x = seat.charAt(i);
            if (x == 'L') {
                c++;
                i++;
            }
        }

        if (c <= 1) {
            System.out.println(cnt);
        } else{
            System.out.println(cnt-c+1);
        }

    }



}

