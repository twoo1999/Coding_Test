class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int rows = board.length;
        int cols = board[0].length;

        int[][] b = new int[rows+1][cols+1];

        for (int[] s : skill) {
            int type = s[0];
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int cost = type == 1 ? -s[5] : s[5];




            b[r1][c1] += cost;
            b[r2+1][c2+1] += cost;
            b[r1][c2+1] -= cost;
            b[r2+1][c1] -= cost;

        }

        for (int i = 0; i < rows+1; i++) {
            for (int j = 0; j < cols+1; j++) {
                if(j == 0) continue;
                b[i][j] += b[i][j - 1];
            }
        }

        for (int i = 0; i < rows+1; i++) {
            for (int j = 0; j < cols+1; j++) {
                if(i == 0) continue;
                b[i][j] += b[i-1][j];
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] += b[i][j];
                if(board[i][j] > 0) answer++;
            }
        }
        return answer;
    }
}