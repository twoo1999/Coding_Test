import java.util.stream.Stream;
import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] times = Stream.of(timetable).mapToInt(x->{
            String[] s = x.split(":");
            int hour = Integer.parseInt(s[0]);
            int min = Integer.parseInt(s[1]);
            return hour * 60 + min;
        }).toArray();

        Arrays.sort(times);


        Queue<Integer> q = new LinkedList<>();

        for (int time : times) {
            q.add(time);
        }

        int ans = 0;

        int cnt = 0;
        while (cnt < n) {
            int now = 9 * 60 + cnt * t;
            int crew = 0;
            int[] crews = new int[m];
            while (!q.isEmpty() && crew < m) {
                int c = q.peek();
                if (c <= now) {
                    crews[crew++] = c;
                    q.poll();
                } else {
                    break;
                }
            }
            if (cnt == n - 1) {
                if(crew < m){ // 자리가 남는 경우
                    ans = now;
                } else{ // 자리가 없는 경우
                    int last = crews[m - 1];
                    ans = last-1;
                }

            }
            cnt++;

        }

        int h = ans / 60;
        int mm = ans % 60;

        answer = String.format("%02d:%02d", h, mm);
        return answer;
    }
}