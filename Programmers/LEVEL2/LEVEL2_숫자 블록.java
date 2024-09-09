import java.util.*;
class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = {};

        int[] arr = new int[(int)(end-begin+1)];
        Arrays.fill(arr, 1);
        for (long i = begin; i <= end; i++) {
            int sqrt = (int)Math.sqrt(i);
            for (long j = 2; j <= sqrt; j++) {
                if(i % j == 0){
                    if (i / j > 10000000){
                        arr[(int)(i-begin)] = (int) j;
                        continue;
                    } else {
                        arr[(int)(i-begin)] = (int)(i/j);

                    }
                    break;
                }

            }

        }

        if(begin == 1){
            arr[0] = 0;
        }
        return arr;
    }
}