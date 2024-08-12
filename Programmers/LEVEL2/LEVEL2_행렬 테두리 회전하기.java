class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = ++cnt;
            }
        }
        for (int x = 0; x < queries.length; x++) {
            int[] q = queries[x];
            int miny = q[0]-1;
            int minx = q[1]-1;
            int maxy = q[2]-1;
            int maxx = q[3]-1;
            int min = Integer.MAX_VALUE;

            int[][] newBoard = new int[rows][columns];
            for (int i = 0; i < board.length; i++) {
                newBoard[i] = board[i].clone();
            }

            for (int i = minx + 1; i <= maxx; i++) {
                if(newBoard[miny][i] < min) min = newBoard[miny][i];
                newBoard[miny][i] = board[miny][i - 1];

            }


            for (int i = miny + 1; i <= maxy; i++) {
                if(newBoard[i][maxx] < min) min = newBoard[i][maxx];
                newBoard[i][maxx] = board[i-1][maxx];
            }


            for (int i = maxx-1; i >= minx; i--) {
                if(newBoard[maxy][i] < min) min = newBoard[maxy][i];
                newBoard[maxy][i] = board[maxy][i + 1];
            }

            for (int i = maxy - 1; i >= miny; i--) {
                if(newBoard[i][minx] < min) min = newBoard[i][minx];
                newBoard[i][minx] = board[i + 1][minx];
            }
            answer[x] = min;
            board = newBoard;
        }

        
        return answer;
    }
    
    
}