import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int L = input[0];
        int C = input[1];

        String [] strs = br.readLine().split(" ");
        char[] chars = new char[C];

        for (int i = 0; i < C; i++) {
            chars[i] = strs[i].charAt(0);
        }
        Arrays.sort(chars);
        ArrayList<Character> con = new ArrayList<>();
        ArrayList<Character> gat = new ArrayList<>();

        for (char ch : chars) {
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') gat.add(ch);
            else con.add(ch);
        }

        ArrayList<String> ans = new ArrayList<>();
        for (int i = 1; i <= gat.size(); i++) {
            if(L - i > con.size()) continue;
            if(L - i  < 2) continue;
            ArrayList<String> conComb = new ArrayList<>();
            ArrayList<String> gatComb = new ArrayList<>();
            comb(L-i, con.size(), con, new char[L-i], 0, 0, conComb);
            comb(i, gat.size(), gat, new char[i], 0, 0, gatComb);

            for (int c = 0; c < conComb.size(); c++) {
                for (int g = 0; g < gatComb.size(); g++) {
                    char[] chs = (conComb.get(c) + gatComb.get(g)).toCharArray();
                    Arrays.sort(chs);
                    ans.add(new String(chs));
                }
            }
        }

        Collections.sort(ans);

        for (String a : ans) {
            System.out.println(a);
        }

    }
    static void comb(int L, int C, ArrayList<Character> chars, char[] ans, int idx, int cnt, ArrayList<String> ar) {
        if(cnt == L){
            String answer = new String(ans);
            ar.add(answer);

            return;
        }

        for (int i = idx; i < C; i++) {
            ans[cnt] = chars.get(i);
            comb(L, C, chars, ans, i+1, cnt+1, ar);
        }


    }

}