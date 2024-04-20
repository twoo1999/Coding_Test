class Solution {
    static int re = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        
        dfs(numbers, target, 0, 0);
        answer = re;
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int sum, int cnt){
        if(cnt == numbers.length){
            if(sum == target){
                re++;
            }
            return;
        } 
        
        dfs(numbers, target, sum+numbers[cnt], cnt+1);
        dfs(numbers, target, sum-numbers[cnt], cnt+1);
        
        
        
    }
}