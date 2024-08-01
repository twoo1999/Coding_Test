import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[][] dirs = {{1, 0}, {0, 1}, {-1, -1}};
        int[][] board = new int[n][n];
        boolean[][] check = new boolean[n][n];
        int cnt = 2;
        int max = n * (2+(n-1))/2;
        board[0][0] = 1;
        check[0][0] =true;
        int x = 0;
        int y = 0;

        int d = 0;
        while (cnt <= max) {
            int[] dir = dirs[d];
            int nextX = x + dir[1];
            int nextY = y + dir[0];
            if(nextX < 0 || nextX >= n){
                d = (d+1)%3;
                continue;
            }
            if(nextY < 0 || nextY >= n){
                d = (d+1)%3;
                continue;
            }
            if(check[nextY][nextX] == true){
                d = (d+1)%3;
                continue;
            }



            board[nextY][nextX] = cnt++;
            check[nextY][nextX] = true;
            x = nextX;
            y = nextY;
        }
        ArrayList<Integer> ar = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i+1; j++){
                ar.add(board[i][j]);
            }
        }
        
        return ar.stream().mapToInt(i->i).toArray();
    }
}