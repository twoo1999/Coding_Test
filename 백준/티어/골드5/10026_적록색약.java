import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int l = Integer.parseInt(br.readLine());
        String[] board = new String[l];
        for (int i = 0; i < l; i++) {
            board[i] = br.readLine();
        }

        ArrayList<Integer> ar = new ArrayList<>();
        Map<Integer, Integer> m = new HashMap<>();
        int[][] group = new int[l][l];
        int totalcnt = 0;
        int team = 0;
        int[][] moves = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (true) {
            if(totalcnt == l*l) break;
            int cnt = 0;
            int sx = -1;
            int sy = -1;
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < l; j++) {
                    if(group[i][j] == 0){
                        sy = i;
                        sx = j;
                        break;
                    }
                }
                if(sy != -1 && sx != -1) break;
            }
            char type = board[sy].charAt(sx);
            Queue<int[]> q = new LinkedList<>();
            q.add(new int[]{sy, sx, type});
            cnt++;
            group[sy][sx] = ++team;
            if(type == 'R' || type == 'G') ar.add(team);

            while (!q.isEmpty()) {
                int[] info = q.poll();

                int y = info[0];
                int x = info[1];
                int color = info[2];

                for (int[] move : moves) {
                    int ny = y + move[0];
                    int nx = x + move[1];

                    if(ny >= l || ny < 0 || nx >= l || nx < 0) continue;
                    if(group[ny][nx] != 0) continue;
                    if (color == 'R' || color == 'G') {
                        if(board[ny].charAt(nx) == 'B') continue;
                    } else{
                        if(color != board[ny].charAt(nx)) continue;
                    }
                    group[ny][nx] = team;
                    q.add(new int[]{ny, nx, color});
                    cnt++;
                }

            }
            m.put(team, cnt);
            totalcnt += cnt;
        }

        int b = team;

        for (int groupNum : ar) {
            int groupCnt = m.get(groupNum);
            int cnt = 0;
            int rg = 0;
            while (true) {
                if(cnt == groupCnt) break;

                int sy = -1;
                int sx = -1;
                for (int i = 0; i < l; i++) {
                    for (int j = 0; j < l; j++) {
                        if(group[i][j] == groupNum){
                            sy = i;
                            sx = j;
                            break;
                        }
                    }
                    if(sy != -1 && sx != -1) break;
                }
                rg++;

                Queue<int[]> q = new LinkedList<>();
                char type = board[sy].charAt(sx);
                q.add(new int[]{sy, sx, type, groupNum});
                group[sy][sx] = 0;
                cnt++;
                while (!q.isEmpty()) {
                    int[] info = q.poll();
                    int y = info[0];
                    int x = info[1];
                    int color = info[2];
                    int n = info[3];


                    for(int[] move : moves){
                        int ny = y + move[0];
                        int nx = x + move[1];

                        if(ny >= l || ny < 0 || nx >= l || nx < 0) continue;
                        if(group[ny][nx] != n) continue;
                        if(color != board[ny].charAt(nx)) continue;

                        q.add(new int[]{ny, nx, type, group[ny][nx]});
                        cnt++;
                        group[ny][nx] = 0;

                    }
                }
            }
            team += rg-1;

        }

        System.out.println(team + " " + b);

    }



}
