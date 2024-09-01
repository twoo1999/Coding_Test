class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long R1 = (long) r1 * r1;
        long R2 = (long) r2 * r2;
        long sum = 0;
        for (int i = 0; i <= r1; i++) {
            long I = (long) i * i;
            long y1 = (long)Math.ceil(Math.sqrt(R1-I)); // 작은 원
            long y2 = (long)(Math.sqrt(R2-I)); // 큰 원
            sum += y2 - y1 + 1;
        }

        for (int i = r1 + 1; i <= r2; i++) {
            long I = (long) i * i;
            sum += (long)(Math.sqrt(R2-I)) + 1; // 큰 원
        }
        
        return sum*4 - (r2-r1+1)*4;
    }
}