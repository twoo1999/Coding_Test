import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
         Stack<Character> st = new Stack<>();
        int cnt = 0;
        int n = number.length() - k;
        String remain = "";
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            while(!st.isEmpty() && st.peek() < c && k-- > 0){
                st.pop();
            }

            st.push(number.charAt(i));
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(st.get(i));

        }
        return sb.toString();
    }
    
}