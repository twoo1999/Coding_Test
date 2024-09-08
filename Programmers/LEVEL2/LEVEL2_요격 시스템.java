import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (x, y) -> x[1] - y[1]);

        int idx = 0;
        int pos = 0;
        for (int i = 1; i <= targets[targets.length - 1][1]; i++) {
            if(targets[idx][1] <= i){
                if(pos <= targets[idx][0]){
                    answer++;
                    pos = i;
                }
                idx++;

            }
        }
        return answer;
    }
}