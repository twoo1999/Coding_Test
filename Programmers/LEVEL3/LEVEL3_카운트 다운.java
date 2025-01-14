class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];

        int[][] DP = new int[100000+1][2];
        for (int i = 1; i <= 20; i++) {
            DP[i][0] = 1;
            DP[i][1] = 1;
            DP[i*2][0] = 1;
            DP[i*2][1] = 0;
            DP[i*3][0] = 1;
            DP[i*3][1] = 0;
        }
        DP[50][0] = 1;
        DP[50][1] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= 20; j++) {
                if(i + j > target) break;
                if (DP[i + j][0] == 0) {
                    DP[i + j][0] = DP[i][0] + 1;
                    DP[i + j][1] = DP[i][1] + 1;
                } else {
                    if (DP[i + j][0] > DP[i][0] + 1) {
                        DP[i + j][0] = DP[i][0] + 1;
                        DP[i + j][1] = DP[i][1] + 1;
                    } else if (DP[i + j][0] == DP[i][0] + 1) {
                        if (DP[i + j][1] < DP[i][1] + 1) {
                            DP[i + j][1] = DP[i][1] + 1;
                        }
                    }
                }
            }
            for (int j = 2; j <= 40; j+=2) {
                if(i + j > target) break;
                if (DP[i + j][0] == 0) {
                    DP[i + j][0] = DP[i][0] + 1;
                    DP[i + j][1] = DP[i][1];
                } else {
                    if (DP[i + j][0] > DP[i][0] + 1) {
                        DP[i + j][0] = DP[i][0] + 1;
                        DP[i + j][1] = DP[i][1];
                    } else if (DP[i + j][0] == DP[i][0] + 1) {
                        if (DP[i + j][1] < DP[i][1]) {
                            DP[i + j][1] = DP[i][1];
                        }
                    }
                }
            }
            for (int j = 3; j <= 60; j+=3) {
                if(i + j > target) break;
                if (DP[i + j][0] == 0) {
                    DP[i + j][0] = DP[i][0] + 1;
                    DP[i + j][1] = DP[i][1];
                } else {
                    if (DP[i + j][0] > DP[i][0] + 1) {
                        DP[i + j][0] = DP[i][0] + 1;
                        DP[i + j][1] = DP[i][1];
                    } else if (DP[i + j][0] == DP[i][0] + 1) {
                        if (DP[i + j][1] < DP[i][1]) {
                            DP[i + j][1] = DP[i][1];
                        }
                    }
                }
            }
            if(i + 50 > target) continue;

            if (DP[i + 50][0] == 0) {
                DP[i + 50][0] = DP[i][0] + 1;
                DP[i + 50][1] = DP[i][1] + 1;
            } else {
                if (DP[i + 50][0] > DP[i][0] + 1) {
                    DP[i + 50][0] = DP[i][0] + 1;
                    DP[i + 50][1] = DP[i][1] + 1;
                } else if (DP[i + 50][0] == DP[i][0] + 1) {
                    if (DP[i + 50][1] < DP[i][1] + 1) {
                        DP[i + 50][1] = DP[i][1] + 1;
                    }
                }
            }
        }
        return DP[target];
    }

}