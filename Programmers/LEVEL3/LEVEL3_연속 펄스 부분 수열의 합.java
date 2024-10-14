
class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        int maxLen = sequence.length; // 파티션의 최대 크기
        int[] pulse1 = new int[maxLen];
        int[] pulse2 = new int[maxLen];

        for(int i = 0 ; i < maxLen; i++){
            if(i % 2 == 0){
                pulse1[i] = 1;
                pulse2[i] = -1;
            } else{
                pulse1[i] = -1;
                pulse2[i] = 1;
            }
        }

        int sum = 0;
        long[] dp1 = new long[maxLen];
        long[] dp2 = new long[maxLen];
        dp1[0] = sequence[0] * pulse1[0];
        long answer1 = dp1[0];
        for (int i = 1; i < maxLen; i++) {
            int n = sequence[i] * pulse1[i];
            dp1[i] =Math.max(dp1[i-1]+n, n);
            answer1 = Math.max(answer1, dp1[i]);
        }

        dp2[0] = sequence[0] * pulse2[0];
        long answer2 = dp2[0];
        for (int i = 1; i < maxLen; i++) {
            int n = sequence[i] * pulse2[i];
            dp2[i] =Math.max(dp2[i-1]+n, n);
            answer2 = Math.max(answer2, dp2[i]);
        }

        answer = Math.max(answer1, answer2);
        return answer;
    }



}