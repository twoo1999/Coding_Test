
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2*w + 1;
        int y = 0;
      
        for(int i = 0 ; i < stations.length; i++){
            int pos = stations[i];
            int x = pos-w;
            int remain = x-y-1;
            
            if(remain > 0){
                answer += (int)Math.ceil(remain*1.0 / range*1.0);
            }
            
            y = pos + w;
            
        }
        
        if(y < n){
            int remain = n -y;
            answer += (int)Math.ceil(remain*1.0 / range*1.0);
        }
        


        return answer;
    }
}