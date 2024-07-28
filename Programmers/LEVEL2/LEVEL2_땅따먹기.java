class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        int[][] dp = new int[land.length][land[0].length];
        for(int i = 0 ; i < land[0].length; i++){
            dp[0][i] = land[0][i];
        }
        for(int y = 1 ; y < land.length; y++){
            for(int x = 0; x < land[0].length; x++){
                int max = 0;
                for(int z = 0; z < land[0].length; z++){
                    if(z == x) continue;
                    max = Math.max(max, dp[y-1][z]);
                }
                dp[y][x] = max + land[y][x];
            }
        }
        
        for(int i =0 ; i < dp[0].length; i++){
            if(dp[dp.length-1][i] > answer){
                answer =dp[dp.length-1][i];
            }
        }

        return answer;
    }
}