class Solution {
    public int solution(String[] board) {
        int O = 0;
        int X = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char point = board[i].charAt(j);
                if(point == 'O') O++;
                else if(point == 'X') X++;
            }
        }

        if(O < X) return 0;

        if(O - X > 1) return 0;
        boolean isOwin = false;
        boolean isXwin = false;
        for (int i = 0; i < 3; i++) {
            int o = 0;
            int x = 0;
            for (int j = 0; j < 3; j++) {
                char point = board[i].charAt(j);
                if(point == 'O') o++;
                else if(point == 'X') x++;
            }

            if(o == 3) isOwin = true;
            if(x == 3) isXwin = true;

        }

        if (!isOwin && !isXwin) {
            for (int i = 0; i < 3; i++) {
                int o = 0;
                int x = 0;
                for (int j = 0; j < 3; j++) {
                    char point = board[j].charAt(i);
                    if(point == 'O') o++;
                    else if(point == 'X') x++;
                }

                if(o == 3) isOwin = true;
                if(x == 3) isXwin = true;

            }
        }
        if (!isOwin && !isXwin) {
            int o = 0;
            int x = 0;
            for (int i = 0; i < 3; i++) {
                char point = board[i].charAt(i);
                if(point == 'O') o++;
                else if(point == 'X') x++;

            }

            if(o == 3) isOwin = true;
            if(x == 3) isXwin = true;
        }
        if (!isOwin && !isXwin) {
            int o = 0;
            int x = 0;
            for (int i = 0; i < 3; i++) {
                char point = board[i].charAt(2-i);
                if(point == 'O') o++;
                else if(point == 'X') x++;

            }

            if(o == 3) isOwin = true;
            if(x == 3) isXwin = true;

        }
        if(isOwin && isXwin) return 0;
        if(isOwin && X != O-1) return 0;
        if(isXwin && X != O) return 0;
        return 1;
    }
}