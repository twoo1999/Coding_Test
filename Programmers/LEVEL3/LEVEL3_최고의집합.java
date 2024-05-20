class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        
        
        int num = (int) s / n;
        if(num == 0){
            return new int[]{-1};
        }
        
        for(int i = 0; i < n; i++){
            answer[i] = num;
        }

        int remain = 0;
        if(s % n != 0){
            remain = s - num*n;
        }

        for(int i = n-1 ; i >= n-remain; i--){
            answer[i] += 1;
        }    

        return answer;
    }
}