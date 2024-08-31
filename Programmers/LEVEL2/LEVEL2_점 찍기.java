class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long a = 0;
        while (a*k <= d) {
            long y = (long) Math.sqrt((long)d*d - (a*k*a*k));
            answer += (y / k) + 1 ;
            a++;
        }
        return answer;
    }
}