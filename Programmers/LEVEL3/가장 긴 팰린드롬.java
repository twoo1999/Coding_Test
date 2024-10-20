import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char l = s.charAt(i);
            for (int j = s.length() - 1; j >= i; j--) {
                char r = s.charAt(j);
                if(r != l) continue;

                int len = j-i+1;
                boolean f = false;
                for (int z = 0; z < len / 2; z++) {
                    char ll = s.charAt(z+i);
                    char rr = s.charAt(j-z);
                    if(ll != rr){
                        f = true;
                        break;
                    }
                }
                if (f == false) {
                    answer = Math.max(j-i+1, answer);
                    break;
                }

            }

        }
        return answer;
    }
}