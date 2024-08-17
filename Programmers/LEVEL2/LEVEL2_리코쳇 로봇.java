import java.util.;

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        Queueint[] q = new LinkedList();
        int rows = board.length;
        int cols = board[0].length();
        boolean[][] check = new boolean[rows][cols];
        int[] start = {0, 0, 0};
        int[] goal = {0, 0};
        for (int i = 0; i  rows; i++) {
            for (int j = 0; j  cols; j++) {
                if(board[i].charAt(j) == 'R') start = new int[]{i ,j};
                else if(board[i].charAt(j) == 'G') goal = new int[]{i, j};
            }
        }

        q.add(new int[]{start[0], start[1], 0});
        check[start[0]][start[1]] = true;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


        while (!q.isEmpty()) {
            int[] point = q.poll();
            int y = point[0];
            int x = point[1];
            int cost = point[2];
            if(y == goal[0] && x == goal[1]){
                answer = cost;
            }

            for (int[] dir  dirs) {
                int cy = y;
                int cx = x;

                int nx = 0;
                int ny = 0;
                while(true){
                    nx = cx + dir[1];
                    ny = cy + dir[0];

                    if(nx  0  nx = cols  ny  0  ny = rows  board[ny].charAt(nx) == 'D'){
                        break;
                    }else{
                        cx = nx;
                        cy = ny;
                    }

                }

                if(check[cy][cx] == true) continue;


                check[cy][cx] = true;
                q.add(new int[]{cy, cx, cost+1});
            }
        }
        return answer == 0  -1  answer;
    }
}