import java.util.*;
class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        int cols = land.length;
        int rows = land[0].length;
        int[][] dirs = {{0, 1},{0, -1},{1, 0},{-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int num = 2;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if(land[i][j] == 1) {
                    q.add(new int[]{i, j});
                    num++;
                }
                int cnt = 0;
                while (!q.isEmpty()) {
                    int[] pos = q.poll();
                    int x = pos[1];
                    int y = pos[0];
                    for (int[] dir : dirs) {
                        int nx = x + dir[1];
                        int ny = y + dir[0];
                        if(nx < 0 || nx >= rows || ny < 0 || ny >= cols) continue;
                        if(land[ny][nx] != 1) continue;
                        land[ny][nx] = num;
                        cnt++;
                        q.add(new int[]{ny, nx});
                    }

                }
                if(cnt != 0) map.put(num, cnt);
            }
        }


        for (int i = 0; i < rows; i++) {
            int sum = 0;
            boolean[] check = new boolean[num+1];
            for (int j = 0; j < cols; j++) {
                int n = land[j][i];
                if(n == 0) continue;
                if(n == 1){
                    sum++;
                } else{
                    int mn= map.get(n);
                    if(check[n] == true) continue;
                    sum += mn;
                    check[n] = true;
                }

            }
            if(answer < sum) answer = sum;
        }
        return answer;
    }
}