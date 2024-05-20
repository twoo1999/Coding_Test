import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] dp = new int[triangle.length][];
        
        for(int i = 0 ; i< triangle.length; i++){
            dp[i] = new int[triangle[i].length];
        }
        
        for(int i = 0; i < triangle.length; i++){
            if(i == 0){
                dp[i][0] = triangle[0][0];
                continue;
            }
            for(int j= 0; j < triangle[i].length; j++){
                if(j == 0){
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if(j == triangle[i].length-1){
                    dp[i][i] = dp[i-1][j-1] + triangle[i][j];
                } else{
                    int x = dp[i-1][j-1];
                    int y = dp[i-1][j];
                    dp[i][j] = Math.max(x, y) + triangle[i][j];    
                }
            }
        }

        return Arrays.stream(dp[triangle.length-1]).max().getAsInt();
    }
    
  
}