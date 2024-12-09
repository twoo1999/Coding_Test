import java.util.*;
class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";


        int[] cnt = new int[100 * 60 * 60 + 60 * 60 + 60];

        int play = changeTimeToInt(play_time);
        int adv = changeTimeToInt(adv_time);
        int[][] log = new int[logs.length][2];

        int min = 0;
        int max= 0;

        int ans = 0;
        for (int i = 0 ; i < logs.length; i++) {
            String l = logs[i];
            String[] ll = l.split("-");
            log[i][0] = changeTimeToInt(ll[0]);
            log[i][1] = changeTimeToInt(ll[1]);
            cnt[log[i][0]]++;
            cnt[log[i][1]]--;
            max = Math.max(max, log[i][1]);
        }


        for (int i = 1; i < play; i++) {
            cnt[i] = cnt[i] + cnt[i-1];
        }

        long sum = 0;
        long s = 0;
        for (int i = 0; i <= play; i++) {
            if (i <= adv) {
                s += cnt[i];
                ans = i;
                sum = s;
            } else{
                s += cnt[i];
                s -= cnt[i-adv];
                if(sum < s){
                    ans = i+1;
                    sum = s;
                }
            }



        }



        return chageTimeToString(ans-adv);
    }
    static int changeTimeToInt(String time) {
        int[] t = Arrays.stream(time.split(":")).mapToInt(x -> Integer.parseInt(x)).toArray();
        return t[0] * 60 * 60 + t[1] * 60 + t[2];
    }


    static String chageTimeToString(long time) {
        long hour = time / (60 * 60);
        long remain = time % (60 * 60);
        long min = remain / (60);
        long sec = remain % 60;
        return String.format("%02d", hour) + ":" + String.format("%02d", min) + ":" + String.format("%02d", sec);
    }
}