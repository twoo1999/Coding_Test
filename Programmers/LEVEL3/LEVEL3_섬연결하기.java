import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        boolean[][] board = new boolean[n][n];
        boolean[] check = new boolean[n];
        Arrays.sort(costs, (x, y)->{
            return x[2] - y[2];
        });
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0 ; i < costs.length; i++){
            int x = costs[i][0];
            int y = costs[i][1];
            int cost = costs[i][2];
            check = new boolean[n];
            q.offer(x);
            while(!q.isEmpty()){
                int pos = q.poll();
                check[pos] = true;
                for(int j = 0 ;j < n; j++){
                    if(pos != j && board[pos][j] && !check[j]){
                        q.offer(j);
                    }
                }
            }
            if(!(check[x] && check[y])){
                board[x][y] = true;
                board[y][x] = true;
                answer += cost;
            }  
        }
        return answer;
    }
    
}