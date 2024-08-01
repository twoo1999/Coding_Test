class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int[] q = new int[queue1.length*2];

        for (int i = 0; i < queue2.length; i++) {
            q[i] = queue1[i];
            q[queue1.length+i] = queue2[i];
        }

        int p1 = 0;
        int p2 = queue1.length;
        int cnt = 0;
        long sum1 = 0;
        long sum2 = 0;
        int len = q.length;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += q[i];
            sum2 += q[queue1.length+i];
        }
        long sum = sum1 + sum2;
        if(sum % 2 != 0){
            return -1;
        }
        long target = sum / 2;
        while (cnt < q.length*2) {

            if (sum1 == target) {
                break;
            } else if (sum1 > target) {
                sum1 -= q[p1];
                p1 = (p1+1)%len;
            } else{
                sum1 += q[p2];
                p2 = (p2+1)%len;
            }
            cnt++;
        }
        if (p1 == p2) {
            cnt = -1;
        }
        if(cnt == q.length*2) return -1;
        return cnt;
    }
    

}