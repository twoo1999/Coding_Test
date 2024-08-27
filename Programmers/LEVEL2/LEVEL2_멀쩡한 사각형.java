class Solution {
    public long solution(int w, int h) {
        long answer = 1;
        int max = w > h ? w : h;
        int min = w > h ? h : w;
        long sum = 0;
        for (int i = 1; i < min; i++) {
            long y = (long)(((max*1.0) * (i*1.0) / (min*1.0)));
            sum += y;
        }
        return sum*2;
    }
    
}