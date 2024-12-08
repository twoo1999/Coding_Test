import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int[] cnt = new int[100 * 60 * 60 + 60 * 60 + 60];

        int play = changeTime(play_time);
        int adv = changeTime(adv_time);
        int[][] log = new int[logs.length][2];

        int min = 0;
        int max= 0;


        for (int i = 0 ; i < logs.length; i++) {
            String l = logs[i];
            String[] ll = l.split("-");
            log[i][0] = changeTime(ll[0]);
            log[i][1] = changeTime(ll[1]);
            cnt[log[i][0]]++;
            cnt[log[i][1]+1]--;
            max = Math.max(max, log[i][1]);
        }


        for (int i = 1; i < play; i++) {
            cnt[i] = cnt[i] + cnt[i-1];
        }
        return answer;
    }
    static int changeTime(String time) {
        int[] t = Arrays.stream(time.split(":")).mapToInt(x -> Integer.parseInt(x)).toArray();
        return t[0] * 60 * 60 + t[1] * 60 + t[0];
    }
}