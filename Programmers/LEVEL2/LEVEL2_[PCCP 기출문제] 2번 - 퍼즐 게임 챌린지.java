class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;

        long left = 1;
        long right = Long.MAX_VALUE-1;

        while (left < right) {
            long mid = (left + right) / 2;
            int result = cal(diffs, times, mid, limit);
            if(result > 0){
                left = mid + 1;
            } else if (result < 0) {
                right = mid;
            } else {
                answer = (int) mid;
                break;
            }
        }


        return answer == 0 ? (int)left : answer;
    }
    static public int cal(int[] diff, int[] times, long level, long limit) {
        long sum = 0;
        sum += times[0];
        for (int i = 1 ; i < diff.length; i++) {
            int cDiff = diff[i];
            if (cDiff > level) {
                sum += (times[i-1] + times[i]) * (cDiff - level) + times[i];
            } else {
                sum += times[i];
            }
        }

        if(sum > limit) return 1; // 시간 초과 -> level 을 높여야함
        else if(sum == limit) return 0; // 시간 정확 -> 해당 level이 최솟값
        else return -1; // 시간 초과 x -> level을 낮춰야함
    }
}