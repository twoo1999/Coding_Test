import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int n = routes.length;
        ArrayList<Integer> ar = new ArrayList<>();
        boolean[] check = new boolean[n];
        
        
        Arrays.sort(routes, (x, y)-> {
            return x[0] != y[0] ? x[0] -y[0] : x[1] -y[1];
        });
        for(int i = 0 ; i < n; i++){
            if(check[i] != true){
                int start = routes[i][0];
                int end = routes[i][1];     
                
                for(int j = i+1; j < n; j++){
                    if(routes[j][0] <= end){
                        start = routes[j][0];
                        if(routes[j][1] < end){
                            end = routes[j][1];
                        }
                        check[j] = true;
                    }
                }
                check[i] = true;
                System.out.println(i);
                answer++;
            }
            
        }

        
        return answer;
    }
    
    
    
}