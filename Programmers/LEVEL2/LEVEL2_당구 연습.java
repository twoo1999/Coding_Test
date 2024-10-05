import java.util.*;

class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for (int i = 0; i < balls.length; i++) {
            int[] ball = balls[i];
            ArrayList<Integer> ar = new ArrayList<>();

            int minX = Math.min(ball[0], startX);
            int maxX = Math.max(ball[0], startX);
            int minY = Math.min(ball[1], startY);
            int maxY = Math.max(ball[1], startY);

            int row;
            int col;

            if(!(startY == ball[1] && startX > ball[0])){
                row = maxX + minX;
                col = maxY - minY;
                ar.add(row * row + col * col);
            }

            if (!(startY == ball[1] && startX < ball[0])) {
                // 오른쪽 벽 쿠션
                row = (m - maxX + m - minX);
                col = maxY - minY;
                ar.add(row * row + col * col);
            }


            if (!(startX == ball[0] && startY < ball[1])) {
                // 위쪽 벽 쿠션
                row = maxX - minX;
                col = ((n - maxY) + (n - minY));
                ar.add(row * row + col * col);
            }

            if (!(startX == ball[0] && startY > ball[1])) {
                // 아래쪽 벽 쿠션
                row = maxX - minX;
                col = minY + maxY;
                ar.add(row * row + col * col);
            }
            answer[i] = Collections.min(ar);
        }
        return answer;
    }
}