import java.util.ArrayList;
import java.util.Collections;
class Solution {
    static ArrayList<Integer> ar = new ArrayList<>();
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        
        int len = dungeons.length;
        int[] arr = new int[len];
        int[] output = new int[len];
        boolean[] visited = new boolean[len];
        
        for(int i= 0; i < len; i++){
            arr[i] = i;
        }
        dfs(arr, visited, 0, dungeons, k);
        return Collections.max(ar)+1;
    }
    
    static void dfs(int[] nums, boolean[] visited, int cnt, int[][] dungeons, int k){
        if(cnt == dungeons.length){
            return;
        }
        for(int i = 0 ; i < nums.length; i++){
            if(visited[i] != true){
                if(dungeons[i][0] <= k){
                    visited[i] = true;
                    ar.add(cnt);
                    dfs(nums, visited, cnt+1, dungeons, k- dungeons[i][1]);
                    visited[i] = false;    
                }
                
            }
        }
    }
    
    
}