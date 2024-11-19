import java.util.*;
class Solution {
    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        int[] prev = new int[n + 1];
        int[] next = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prev[i] = i-1;
            next[i] = i+1;
        }

        next[n - 1] = -1;

        Stack<int[]> st = new Stack<>();

        for (String c : cmd) {
            String[] command = c.split(" ");
            String type = command[0];
            switch (type) {
                case "D":
                    int cnt = Integer.parseInt(command[1]);
                    int end;
                    for (int i = 0; i < cnt; i++) {
                        k = next[k];
                    }
                    break;
                case "U":
                    int cnt1 = Integer.parseInt(command[1]);
                    for (int i = 0; i < cnt1; i++) {
                        k = prev[k];
                    }
                    break;
                case "C":
                    st.push(new int[]{prev[k], k, next[k]});
                    if(prev[k] != -1) next[prev[k]] = next[k];
                    if(next[k] != -1) prev[next[k]] = prev[k];

                    if(next[k] == -1) k = prev[k];
                    else k = next[k];
                    break;
                case "Z":
                    int[] d = st.pop();
                    if(d[0] != -1) next[d[0]] = d[1];
                    if(d[2] != -1) prev[d[2]] = d[1];

            }
        }




        char[] str = new char[n];
        Arrays.fill(str, 'O');

        while (!st.isEmpty()) {
            str[st.pop()[1]] = 'X';
        }
        answer = new String(str);


        return answer;
    }
}