class Solution {
    static int min;
    public int solution(int storey) {
        min = storey;
        int ans = 0;
        dfs(storey, 0);
        return min;
    }
    
    static void dfs(int n, int cnt){
        if (n == 0) {
            if (cnt < min) {
                min = cnt;
            }
            return;
        }
        int d = n % 10;
        dfs(n/10, cnt+d);
        if (n / 10 != 0) {
            dfs(n/10+1, cnt+10-d);
        } else{
            if(n > 5){
                dfs(n/10+1, cnt+10-d);
            } else{
                dfs(n/10, cnt+d);
            }
        }

    }
}