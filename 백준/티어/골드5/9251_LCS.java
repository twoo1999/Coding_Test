import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] DP = new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    DP[i][j] = DP[i-1][j-1] + 1;
                } else{
                    DP[i][j] = Math.max(DP[i - 1][j], DP[i][j - 1]);
                }
            }
        }

        System.out.println(DP[len1][len2]);
    }
}