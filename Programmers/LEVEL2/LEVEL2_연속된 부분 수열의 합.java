import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        
        int start = 0;
        int end = sequence.length;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        int si = 0;
        int ei = 0;
        for (int i = 0; i < sequence.length; i++) {
            int n = sequence[i];
            if (!q.isEmpty()) {

                if (sum + n < k) {
                    ei++;
                    sum += n;
                    q.add(n);
                    continue;
                }

                while (!q.isEmpty() && sum + n > k) {
                    int p = q.poll();
                    sum -= p;
                    si++;
                }
                q.add(n);
                sum += n;
                ei++;
            }else{
                q.add(n);
                sum += n;
            }
            if(sum == k){
                if(end - start > ei-si){
                    start = si;
                    end = ei;
                }
            }
        }
        return new int[]{start, end};
    }
}