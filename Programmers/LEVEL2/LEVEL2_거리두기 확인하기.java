import java.util.*;


class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        
        for(int i = 0 ; i < places.length; i++){
            int re = func(places[i]);
            answer[i] = re;
        }

        
        
        return answer;
    }
    
    static int func(String[] place){
        int[][] dir1 = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] dir2 = {{-1, 1}, {1, 1}, {1, -1}, {-1 ,-1}};
        
        int[][] dir31 = {{-2, 0}, {2, 0}};
        int[][] dir32 = { {0, -2}, {0, 2}};
        
        for(int y = 0 ; y < 5; y++){
            for(int x = 0 ; x < 5; x++){
                char curr = place[y].charAt(x);
                if(curr == 'P'){
                    for(int[] dir : dir1){
                        int nextX = x + dir[1];
                        int nextY = y + dir[0];
                        if(nextX >= 5 || nextX < 0 || nextY >= 5 || nextY < 0){
                            continue;
                        }
                        if(place[nextY].charAt(nextX) == 'P'){
                            return 0;
                        }
                    }
                    
                    for(int[] dir: dir2){
                        int nextX = x + dir[1];
                        int nextY = y + dir[0];
                        if(nextX >= 5 || nextX < 0 || nextY >= 5 || nextY < 0){
                            continue;
                        }
                        if(place[nextY].charAt(nextX) == 'P'){
                            if(place[nextY].charAt(x) == 'O' || place[y].charAt(nextX) == 'O'){
                                return 0;
                            }
                        }
                    }
                    
                    
                    for(int[] dir: dir31){
                            
                        int nextX = x + dir[1];
                        int nextY = y + dir[0];
                        if(nextX >= 5 || nextX < 0 || nextY >= 5 || nextY < 0){
                            continue;
                        }
                        if(place[nextY].charAt(nextX) == 'P'){
                            if(place[nextY + (dir[0] > 0 ? -1 : 1)].charAt(x) == 'O'){
                                return 0;
                            }
                        }
                    }
                    for(int[] dir: dir32){
                        int nextX = x + dir[1];
                        int nextY = y + dir[0];
                        if(nextX >= 5 || nextX < 0 || nextY >= 5 || nextY < 0){
                            continue;
                        }
                            
                        if(place[nextY].charAt(nextX) == 'P'){
                            if(place[nextY].charAt(nextX + (dir[1] > 0 ? -1 : 1)) == 'O'){
                                return 0;
                            }
                        }
                    }
                }
            }
        }

        return 1;
  
    }   
}