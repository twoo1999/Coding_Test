import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int n = routes[0].length;

        int[] target = new int[routes.length];
        int[][] currentPoint = new int[routes.length][2];
        while (!isEnd(target, routes[0].length)) {
            Set<Integer> s = new HashSet<>();
            for (int robot = 0; robot < routes.length; robot++) {
                int currentTargetIdx = target[robot];
                if(currentTargetIdx == n){
                    target[robot]++;
                    continue;
                } else if (currentTargetIdx > n) {
                    continue;
                }

                if(currentTargetIdx == 0){
                    currentPoint[robot] = points[routes[robot][currentTargetIdx]-1].clone();
                    currentTargetIdx = 1;
                    target[robot]++;

                    for (int i = robot - 1; i >= 0; i--) {
                        int[] iPoint = currentPoint[i];
                        if(target[i] > n) continue;
                        if(iPoint[0] == currentPoint[robot][0] && iPoint[1] == currentPoint[robot][1]){
                            s.add(currentPoint[robot][0] * 100 + currentPoint[robot][1]);
                        }
                    }
                    continue;
                }

                int currentTarget = routes[robot][currentTargetIdx];
                int[] tartgetPoint = points[currentTarget-1];
                // 높이가 다른 경우
                int cx = currentPoint[robot][1];
                int cy = currentPoint[robot][0];
                int tx = tartgetPoint[1];
                int ty = tartgetPoint[0];
                if (cy != ty){
                    if (cy > ty) {
                        currentPoint[robot][0] = cy - 1;
                    } else{
                        currentPoint[robot][0] = cy + 1;
                    }
                } else if (cx != tx) {
                    if (cx > tx) {
                        currentPoint[robot][1] = cx - 1;
                    } else{
                        currentPoint[robot][1] = cx + 1;
                    }
                }
                for (int i = robot - 1; i >= 0; i--) {
                    int[] iPoint = currentPoint[i];
                    if(target[i] > n) continue;
                    if(iPoint[0] == currentPoint[robot][0] && iPoint[1] == currentPoint[robot][1]){
                        s.add(currentPoint[robot][0] * 100 + currentPoint[robot][1]);
                    }
                }

                if (currentPoint[robot][0] == ty && currentPoint[robot][1] == tx) {
                    target[robot]++;
                }
            }

            answer += s.size();
        }
        return answer;
    }
    static public boolean isEnd(int[] target, int n) {
        for (int t : target) {
            if(t < n) return false;
        }

        return true;
    }
}