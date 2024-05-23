import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        int[] routes = new int[n+1];
        routes[0] = routes[1] = 0;
        q.offer(1);
        int cnt = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            if(curr == 1){
                cnt = 1;
            } else{
                cnt = routes[curr]+1;
            }
            for(int i = 0; i < edge.length; i++){
                if(curr == edge[i][0]){
                    if(routes[edge[i][1]] == 0 && edge[i][1] != 1){
                        routes[edge[i][1]] = cnt;
                        q.offer(edge[i][1]);
                    }
                } else if(curr == edge[i][1] ){
                    if(routes[edge[i][0]] == 0 && edge[i][0] != 1){
                        routes[edge[i][0]] = cnt;
                        q.offer(edge[i][0]);
                    }
                }
            }
        }

        int max = 0;
        int a = 0;
        for(int i : routes){
            if(max < i){
                max = i;
                a = 1;
            } else if(max == i){
                a++;
            }
        }
        
        
        
        
        
        
        return a;
    }
}