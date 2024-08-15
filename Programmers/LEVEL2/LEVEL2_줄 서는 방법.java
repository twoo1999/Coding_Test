import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = {};
        
        ArrayList<Integer> ar = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ar.add(i);
        }

        long[] DP = new long[n+1];
        DP[1] = 1;
        DP[2] = 2;
        for (int i = 3; i <= n; i++) {
            DP[i] = i * DP[i - 1];
        }


        ArrayList<Integer> a = new ArrayList();
        while (n > 1) {
            long cnt = DP[n-1];
            long x = (k-1) / cnt;
            long y = k - x*cnt;

            a.add((int)ar.get((int)x));
            ar.remove((int)x);
            k = y;

            n--;


        }
        a.add(ar.get(0));
        int[] ans = new int[a.size()];
        for (int i = 0; i < a.size(); i++) {
            ans[i] = a.get(i);
        }
        return ans;
    }
}