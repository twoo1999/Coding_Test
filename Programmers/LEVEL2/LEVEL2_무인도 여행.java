import java.util.*;
class Solution {
    static int n = 0;
    public int[] solution(String[] maps) {
        int[] answer = {};
        ArrayList<Integer> ar = new ArrayList<>();
        int row = maps.length;
        int col = maps[0].length();
        int[][] map = new int[row][col];
        boolean[][] check = new boolean[row][col];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(maps[i].charAt(j) == 'X'){
                    map[i][j] = 0;
                } else {
                    map[i][j] = maps[i].charAt(j) - '0';
                }
            }
        }


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                n = 0;
                if (check[i][j] == true || map[i][j] == 0) {
                    continue;
                }

                dfs(map, check, i, j, row, col);
                ar.add(n);


            }
        }
        answer = ar.stream().mapToInt(i->i).toArray();
        Arrays.sort(answer);
        return answer.length != 0 ?answer : new int[]{-1};
    }
    static void dfs(int[][] map, boolean[][] check, int y, int x, int row, int col){
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        check[y][x] = true;
        n += map[y][x];
        for (int[] dir : dirs) {
            int nx = x + dir[1];
            int ny = y + dir[0];

            if (nx >= col || nx < 0 || ny >= row || ny < 0) {
                continue;
            }
            if(check[ny][nx] == true || map[ny][nx] == 0) continue;


            dfs(map, check, ny, nx, row, col);
        }
    }
}