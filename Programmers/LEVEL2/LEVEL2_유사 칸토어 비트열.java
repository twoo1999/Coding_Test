class Solution {
    public int solution(int n, long l, long r) {
        int answer = 0;

        long left = l-1;
        long right = r-1;
        long cnt = (long) Math.pow(5, n);

        int ans = dfs(left, right, 0, cnt-1, cnt);
        return ans;
    }
    static public int dfs(long left, long right, long start, long end, long cnt) {
        if(cnt == 5){
            String str = "11011";
            if(right < start || left > end) return 0;

            // 1. left와 right 가 모두 구간안에 있을 때
            // 2. left만 구간안에 있을 때
            // 3. right만 구간 안에 있을 때
            // 4. 모두 바깥에 있을 때

            if (left >= start && right <= end) {
                int l = (int)(left % 5);
                int r = l + (int) (right - left);
                int s = (int)str.substring(l, r+1).chars().filter(c->c=='1').count();
                return s;
            } else if (left >= start && right > end) {
                int l = (int)(left % 5);
                int s = (int) str.substring(l, 5).chars().filter(c -> c == '1').count();
                return s;
            } else if(right <= end && left < start){
                int r = (int) (right % 5);
                int s = (int) str.substring(0, r+1).chars().filter(c -> c == '1').count();
                return s;
            } else if (right > end && left < start) {
                return 4;
            }

        }
        int sum = 0;
        long range = cnt / 5;
        long sideRange = range * 2;
        long leftEnd = start + range*2;
        long lmid = start + range;
        long rightStart = start + sideRange + range;
        long rmid = rightStart + range;
        if(right >= start && left <= end){
            sum += dfs(left, right, start, lmid-1, range);
            sum += dfs(left, right, lmid, leftEnd-1, range);
            sum += dfs(left, right, rightStart, rmid-1, range);
            sum += dfs(left, right, rmid, end, range);
        }

        return sum;


    }

}