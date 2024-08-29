import java.util.*;
class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        ArrayList<Double> list = new ArrayList<>();
        while (k != 1) {
            int prevk = k;
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 +1;
            }


            list.add(((double) (prevk + k) / 2));


        }
        answer = new double[ranges.length];
        for (int idx = 0; idx < ranges.length; idx++) {
            int start = ranges[idx][0];
            int end = list.size() + ranges[idx][1];
            if (start > end) {
                answer[idx] = -1;
                continue;
            }
            double sum = 0;

            for (int i = start; i < end; i++) {
                sum += list.get(i);
            }

            answer[idx] = sum;
        }
        return answer;
    }
}