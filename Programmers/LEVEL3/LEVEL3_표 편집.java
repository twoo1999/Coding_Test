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

        Stack<Integer> st = new Stack<>();

        for (String c : cmd) {
            String[] command = c.split(" ");
            String type = command[0];
            switch (type) {
                case "D":
                    int cnt = Integer.parseInt(command[1]);
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
                    st.push(k);
                    if(prev[k] != -1) next[prev[k]] = next[k];
                    if(next[k] != -1) prev[next[k]] = prev[k];

                    if(next[k] == -1) k = prev[k];
                    else k = next[k];
                    break;
                case "Z":
                    int d = st.pop();
                    if(prev[d] != -1) next[prev[d]] = d;
                    if(next[d] != -1) prev[next[d]] = d;

            }
        }




        char[] str = new char[n];
        Arrays.fill(str, 'O');

        while (!st.isEmpty()) {
            str[st.pop()] = 'X';
        }
        answer = new String(str);


        return answer;
    }
}