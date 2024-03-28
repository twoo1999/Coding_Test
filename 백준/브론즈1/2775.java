import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        int cnt = Integer.parseInt(sc.nextLine());
        List<Integer> k = new ArrayList<>();
        List<Integer> n = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            k.add(Integer.parseInt(sc.nextLine()));
            n.add(Integer.parseInt(sc.nextLine()));
        }

        int maxk = Collections.max(k)+1;
        int maxn = Collections.max(n)+1;

        int[][] arr = new int[maxk][maxn];

        for (int i = 1; i < maxn; i++) {
            arr[0][i] = i;
        }

        for (int i = 0; i < maxk; i++) {
            arr[i][1] = 1;
        }
        for (int i = 1; i < maxk; i++) {
            for (int j = 2; j < maxn; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        for (int i = 0; i < cnt; i++) {
            int kk = k.get(i);
            int nn = n.get(i);
            System.out.println(arr[kk][nn]);
        }
    }



}

