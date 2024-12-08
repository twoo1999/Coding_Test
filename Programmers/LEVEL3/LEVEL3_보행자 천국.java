class Solution {
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int[][] DP = new int[m][n];
        int MOD = 20170805;

        DP[0][0] = 1;

        for (int y = 0; y < m ; y++) {
            for (int x = 0; x < n; x++) {
                if(cityMap[y][x] >= 1) continue;
                int ny = y + 1;
                while (ny < m && cityMap[ny][x] == 2) {
                    ny++;
                }
                if (ny < m && cityMap[ny][x] != 1) {
                    DP[ny][x] = (DP[ny][x]+ DP[y][x])%MOD;
                }
                int nx = x + 1;
                while (nx < n && cityMap[y][nx] == 2) {
                    nx++;
                }
                if (nx < n && cityMap[y][nx] != 1 ) {
                    DP[y][nx] = (DP[y][nx] + DP[y][x])%MOD;
                }
            }
        }
        return DP[m-1][n-1];
    }
}