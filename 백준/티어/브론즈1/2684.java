import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        String[] c = {"TTT", "TTH", "THT", "THH", "HTT", "HTH", "HHT", "HHH"};
        int[][] result = new int[cnt][8];
        for (int i = 0; i < cnt; i++) {
            int[] re = {0, 0, 0, 0, 0, 0, 0, 0};
            String coin = sc.nextLine();
            for (int j = 0; j < 38; j++) {
                String sub = coin.substring(j, j + 3);
                for (int z = 0; z < 8; z++) {
                    if (c[z].equals(sub)) {
                        re[z]++;
                    }
                }
            }
            for (int q = 0; q < 8; q++) {
                result[i][q] = re[q];
            }
        }


        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }

    }

}
