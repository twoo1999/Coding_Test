import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int row  = sc.nextInt();
        int col = sc.nextInt();

        System.out.println((row-1) + (row)*(col-1));



    }

}
