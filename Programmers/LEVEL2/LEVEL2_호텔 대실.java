import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int[][] bt = new int[book_time.length][2];
        ArrayList<int[]> ar = new ArrayList<>();
        for (int i = 0; i < book_time.length; i++) {
            String[] time = book_time[i];
            bt[i][0] = calTime(time[0]);
            bt[i][1] = calTime(time[1]);
        }
        
        Arrays.sort(bt, (x, y)-> x[0]-y[0]);
        
        for (int[] time : bt) {
            if (ar.size() == 0) {
                ar.add((int[]) time.clone());
                continue;
            }
            int start = time[0];
            int end = time[1];
            int cnt = ar.size();
            for (int i = 0; i < cnt; i++) {
                int[] room = ar.get(i);
                if (room[1]+10 <= start) {
                    room[0] = start;
                    room[1] = end;
                    break;
                }
                if (i == ar.size() - 1) {
                    ar.add((int[]) time.clone());
                    Collections.sort(ar, (x, y)->x[1]-y[1]);
                }
            }
        }
        return ar.size();
    }
    static int calTime(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]) * 60;
        int m = Integer.parseInt(t[1]);

        return h + m;
    }
}