class Solution {
    public int solution(int n) {
        int answer = 0;
        long[] DP = new long[n+1];

        DP[0] = 0;
        DP[1] = 0;
        DP[2] = 3;
        DP[3] = 0;
        for (int i = 3; i <= n; i++) {

            if (i % 2 != 0) {
                DP[i] = 0;
                continue;
            }
            // 6 4 2,0
            DP[i] = DP[i-2]*DP[2];
            for (int j = i - 4; j >= 0; j-=2) {
                DP[i] += DP[j]*2;
            }
            DP[i] += 2;
            DP[i] %= 1000000007;


        }
        return (int)DP[n];
    }
}