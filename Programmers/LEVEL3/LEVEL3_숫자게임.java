import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int cnt = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int a = 0;
        int b = 0;
        
        while(a < cnt && b < cnt){
            if(A[a] < B[b]){
                answer++;
                a++;
                b++;
            } else{
                b++;
            }
        }
        
        return answer;
    }
}