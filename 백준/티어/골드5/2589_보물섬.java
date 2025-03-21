import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int row = info[0];
        int col = info[1];

        char[][] board = new char[row][col];

        for(int r = 0; r < row; r++){
            board[r] = br.readLine().toCharArray();
        }

        int[][] group = new int[row][col];
        int[][] moves = {{1, 0},{-1, 0},{0, 1},{0, -1}};
        int team = 0;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(board[r][c] == 'W') continue;
                if(group[r][c] != 0) continue;
                team++;
                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{r, c});

                while(!q.isEmpty()){
                    int[] posInfo = q.poll();
                    int y = posInfo[0];
                    int x = posInfo[1];
                    for(int[] move : moves){
                        int ny = move[0] + y;
                        int nx = move[1] + x;
                        if(ny >= row || ny < 0 || nx >= col || nx < 0) continue;
                        if(group[ny][nx] != 0) continue;
                        if(board[ny][nx] == 'W') continue;

                        group[ny][nx] = team;
                        q.add(new int[]{ny, nx});
                    }
                }
            }
        }
        int max = 0;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(board[r][c] == 'W') continue;
                if(group[r][c] == 0) continue;

                Queue<int[]> q = new LinkedList<>();
                q.add(new int[]{r, c, 0});
                int g = group[r][c];
                boolean[][] isVisit = new boolean[row][col];
                isVisit[r][c] = true;
                while(!q.isEmpty()){
                    int[] posInfo = q.poll();
                    int y = posInfo[0];
                    int x = posInfo[1];
                    int cnt = posInfo[2];

                    for(int[] move : moves){
                        int ny = move[0] + y;
                        int nx = move[1] + x;

                        if(ny >= row || ny < 0 || nx >= col || nx < 0) continue;
                        if(group[ny][nx] != g) continue;
                        if(isVisit[ny][nx]) continue;


                        max = Math.max(max, cnt + 1);

                        isVisit[ny][nx] = true;
                        q.add(new int[]{ny, nx, cnt+1});
                    }
                }
            }
        }
        System.out.println(max);
    }


}