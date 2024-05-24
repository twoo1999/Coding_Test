import java.util.*;


class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 0;
        Arrays.sort(times);
        long end = times[times.length-1]* (long)n;
        
        while(start < end){
            long mid = (start + end) / 2;
            long count = getPeople(times, mid);
            if(count >= n){
                end = mid;
            } else{
                start = mid+1;
            }
            
        }
        
        return start;
    }
    
    
    static long getPeople(int[] times, long mid){
        long sum = 0;
        for(int t : times){
            sum += (mid / t);
        }
        
        return sum;
    }
}
