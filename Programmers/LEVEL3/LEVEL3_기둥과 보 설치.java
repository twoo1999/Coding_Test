import java.util.*;
class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};

        int[][] board = new int[n + 1][n + 1];


        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int b = build[3];

            int[][] newBoard = copy(board);
            if (a == 0 && b == 1) { // 기둥 설치
                newBoard[y][x] = newBoard[y][x] != 0 ? 3 : 1;
            } else if(a == 0 && b == 0) { // 기둥 삭제
                newBoard[y][x] = newBoard[y][x] == 3 ? 2 : 0;
            } else if(a == 1 && b == 1){ // 보 설치
                newBoard[y][x] = newBoard[y][x] != 0 ? 3 : 2;
            } else if(a == 1 && b == 0){ // 보 삭제
                newBoard[y][x] = newBoard[y][x] == 3 ? 1 : 0;
            }

            boolean isCorrect = isCorrect(newBoard, n);
            if(isCorrect) board = newBoard;
        }


        ArrayList<int[]> ar = new ArrayList<>();


        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if(board[i][j] == 1){
                    ar.add(new int[]{j, i, 0});
                } else if(board[i][j] == 2){
                    ar.add(new int[]{j, i, 1});
                } else if(board[i][j] == 3){
                    ar.add(new int[]{j, i, 0});
                    ar.add(new int[]{j, i, 1});
                }

            }
        }

        Collections.sort(ar, (x, y)->{
            if(x[0] != y[0]){
                return x[0] - y[0];
            } else if(x[1] != y[1]){
                return x[1] - y[1];
            } else{
                return x[2] - y[2];
            }
        });
        answer = new int[ar.size()][3];

        for (int i = 0; i < ar.size(); i++) {
            answer[i] = ar.get(i);
        }


        return answer;
    }
    static int[][] copy(int[][] board){
        int[][] newB = new int[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                newB[i][j] = board[i][j];
            }
        }

        return newB;
    }
    static boolean isCorrect(int[][] board, int n){
        for (int y = 0; y <= n; y++) {
            for (int x = 0; x <= n; x++) {
                if(board[y][x] == 1 || board[y][x] == 3){ // 기둥
                    if(y ==  0) continue;
                    boolean c1 = x != 0 ? board[y][x-1] >= 2 : false; // 왼쪽 보가 있는 경우
                    boolean c2 = x != n ? board[y][x] >= 2 : false; // 오른쪽 보가 있는 경우
                    boolean c3 = y != 0 ? board[y-1][x] == 1 : false; // 밑 기둥이 있는 경우
                    boolean c4 = y != 0 ? board[y-1][x] == 3 : false; // 밑 기둥이 있는 경우
                    if(!(c1 || c2 || c3 || c4)) return false;
                }
                if (board[y][x] >= 2) { // 보
                    boolean c1 = x != 0 ? board[y][x - 1] >= 2 : false;// 왼쪽 연결되어 있는 경우
                    boolean c2 = x != n ? board[y][x + 1] >= 2 : false; // 오른쪽 연결되어 있는 경우
                    boolean c3 = y != 0 ? board[y-1][x] == 1 || board[y-1][x] == 3 : false;
                    boolean c4 = y != 0 && x != n ? board[y-1][x+1] == 1 || board[y-1][x+1] == 3 : false;
                    if(!((c1 && c2) || c3 || c4)) return false;
                }
            }

        }

        return true;
    }
}