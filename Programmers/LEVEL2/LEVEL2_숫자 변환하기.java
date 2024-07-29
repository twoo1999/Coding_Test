import java.util.*;

class Solution {
    static int min = -1;
    public int solution(int x, int y, int n) {
        int answer = 0;
        if(x == y) return 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, 0});
        while(!q.isEmpty()){
            int[] d = q.poll();
            int val = d[0];
            int cnt = d[1];
            int next = 0;
            if(val % 2 == 0){
                next  = val / 2;
                if(next == x){
                    return cnt+1;
                }
                if(next > x){
                    q.add(new int[]{next, cnt+1});
                }
            }
            if (val % 3 == 0) {
                next = val / 3;
                if(next == x){
                    return cnt + 1;
                }
                if(next > x ){
                    q.add(new int[]{next, cnt+1});
                }
            }
            next = val - n;
            if(next == x){
                return cnt+1;
            }
            if(next > x){
                q.add(new int[]{next, cnt+1});
            }
        }
        return -1;
    }
    
//     static void dfs(int x, int y, int n, int cnt){
//         if(min != -1 && cnt > min){
//             return;
//         }
//         if(x > y){
//             return;
//         }

//         if (x == y) {
//             if(min == -1){
//                 min = cnt;
//             } else {
//                 if(min > cnt){
//                     min = cnt;
//                 }
//             }
//             return;
//         }

//         if(y % 2 == 0){
//             dfs(x, y/2, n, cnt+1);
//         } 
        
//         if(y % 3 == 0) {
//             dfs(x, y/3, n, cnt+1);
//         }

//         dfs(x, y-n, n, cnt+1);

//     }
    
}