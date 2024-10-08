import java.util.*;

class Solution {
    public int[] solution(String[] grid) {
        int[] answer = {};

        ArrayList<Integer> ar = new ArrayList<>();

        int c = grid.length;
        int r = grid[0].length();
        boolean[][][] check = new boolean[c][r][4];

        for (int y = 0; y < c; y++) {
            for (int x = 0; x < r; x++) {
                for (int d = 0; d < 4; d++) {
                    // 0 -> 위
                    // 1 -> 오른쪽
                    // 2 -> 아래
                    // 3 -> 왼쪽
                    if (check[y][x][d] != true) {
                        int cnt = 0;
                        int dir = d;
                        int ypos = y;
                        int xpos = x;
                        while (check[ypos][xpos][dir] != true) {
                            cnt++;
                            char g = grid[ypos].charAt(xpos);
                            int[] nextDir = getNextDir(g, dir);
                            int ny = ypos + nextDir[0];
                            ny = ny >= 0 ? ny % c : ny + c;
                            int nx = xpos + nextDir[1];
                            nx = nx >= 0 ? nx % r : nx + r;
                            check[ypos][xpos][dir] = true;
                            ypos = ny;
                            xpos = nx;
                            if (nextDir[0] == 1) dir = 0;
                            else if(nextDir[0] == -1) dir = 2;
                            else if(nextDir[1] == 1) dir = 3;
                            else if(nextDir[1] == -1) dir = 1;
                        }
                        ar.add(cnt);
                    }
                }
            }
        }
        Collections.sort(ar);
        return ar.stream().mapToInt(x->x).toArray();
    }
    static int[] getNextDir(char kind, int from){
        switch (kind) {
            case 'S':
                switch (from){
                    case 0: // 위
                        return new int[]{1, 0};
                    case 1: // 오른쪽
                        return new int[]{0, -1};
                    case 2: // 아래
                        return new int[]{-1, 0};
                    case 3: // 왼쪽
                        return new int[]{0, 1};
                }
            case 'L': // 왼쪽
                switch (from){
                    case 0: // 위
                        return new int[]{0, 1};
                    case 1: // 오른쪽
                        return new int[]{1, 0};
                    case 2: // 아래
                        return new int[]{0, -1};
                    case 3: // 왼쪽
                        return new int[]{-1, 0};
                }
            case 'R':
                switch (from){
                    case 0: // 위
                        return new int[]{0, -1};
                    case 1: // 오른쪽
                        return new int[]{-1, 0};
                    case 2: // 아래
                        return new int[]{0, 1};
                    case 3: // 왼쪽
                        return new int[]{1, 0};
                }
        }
        return new int[]{-1, -1};
    }
}