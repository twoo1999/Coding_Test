import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = {};
        answer = new String[plans.length];
        int i = 0;

        for (String[] plan : plans) {
            plan[1] = transTime(plan[1]);
        }
        Arrays.sort(plans, (x, y)->Integer.parseInt(x[1]) - Integer.parseInt(y[1]));

        Stack<String[]> st = new Stack<>();

        st.add(plans[0]);
        int idx = 1;
        while (idx < plans.length) {
            String[] homework = st.peek();
            String[] next = plans[idx];

            int cStartTime = Integer.parseInt(homework[1]);
            int cProcTime = Integer.parseInt(homework[2]);

            int nStartTime = Integer.parseInt(next[1]);

            int timeGap = nStartTime - cStartTime;


            timeGap -= cProcTime;
            if (timeGap == 0) {
                answer[i++] = st.pop()[0];

            } else if (timeGap < 0) {
                homework[2] = Integer.toString(-timeGap);
            } else{
                answer[i++] = st.pop()[0];
                while (timeGap > 0) {
                    if(st.isEmpty()) break;

                    String[] prev = st.peek();
                    int pProcTime = Integer.parseInt(prev[2]);
                    timeGap -= pProcTime;
                    if (timeGap == 0) {
                        answer[i++] = st.pop()[0];
                    } else if (timeGap < 0) {
                        prev[2] = Integer.toString(-timeGap);
                    } else {
                        answer[i++] = st.pop()[0];
                    }
                }
            }
            st.push(next);
            idx++;
        }

        while (!st.isEmpty()) {
            answer[i++] = st.pop()[0];
        }
        return answer;
    }
    static String transTime(String time){
        String[] t = time.split(":");
        int sum = 0;
        sum += Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
        return Integer.toString(sum);
    }
}