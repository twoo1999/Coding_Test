import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data, (x, y)->{
            int xx = x[col-1];
            int yy = y[col-1];
            if(xx != yy) return xx - yy;
            else return y[0] - x[0];
        });


        for (int i = row_begin - 1; i < row_end; i++) {
            int sum = 0;
            for (int j = 0; j < data[0].length; j++) {
                sum += data[i][j]%(i+1);
            }
            answer ^= sum;
        }
        return answer;
    }
}