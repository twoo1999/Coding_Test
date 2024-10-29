import java.util.*;
class Solution {
    public int solution(int[] a) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        answer += 2;
        int lm = a[0];
        int[] right = Arrays.copyOfRange(a, 1, a.length);
        int[] sright = Arrays.stream(right).sorted().toArray();
        int rm = sright[0];
        int ridx = 0;
        for (int i = 1; i < a.length-1; i++) {
            int mid = a[i];

            set.add(a[i - 1]);

            if(a[i-1] < lm){
                lm = a[i - 1];
            }

            if (rm == mid) {
                while (set.contains(sright[ridx+1])) {
                    ridx++;
                }

                rm = sright[ridx + 1];
                ridx++;
            }

            if (lm > mid || rm > mid) {
                answer++;
            }


        }
        return answer;
    }

}