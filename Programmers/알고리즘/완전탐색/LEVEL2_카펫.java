class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        
        
        int v = 1;
        int w = yellow;
        while(true){
            if(w * v == yellow){
                if(2 * w + 2 * v + 4 == brown){
                    break;
                }
            }
            
            v += 1;
            w  = yellow / v;
            
             
        }
        
        
        return v > w ? new int[]{v+2, w+2} : new int[]{w+2, v+2};
    }
}