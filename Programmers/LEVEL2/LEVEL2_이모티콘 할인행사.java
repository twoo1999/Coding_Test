import java.util.*;
import java.util.stream.Collectors;
class Solution {
    static int peopleAns = 0;
    static int costAns = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        int[] per = new int[emoticons.length];
        int[] rate = {10, 20, 30, 40};
        func(users, emoticons, per, rate, 0);
        
        return new int[]{peopleAns, costAns};
    }
    
    
    void func(int[][] users, int[] emoticons, int[] per, int[] rate, int cnt){
        if(cnt == per.length){
            cal(users, emoticons, per);
            return;
        }
        
        for(int i = 0 ; i < rate.length; i++){
            per[cnt] = rate[i];
            func(users, emoticons, per, rate, cnt+1);
        }
        
        
        
        
    } 
    
    void cal(int[][] users, int[] emoticons, int[] per){
        int people = 0;
        int cost = 0;

        for(int[] user: users){
            int want = user[0];
            int limit = user[1];
            int total = 0;
            for(int i =0 ;i < emoticons.length; i++){
                int p = per[i];
                if(p >= want){
                    int e = emoticons[i];
                    int c = e - (e * p / 100);
                    total += c;
                }
            }
            
            if(limit <= total){
                people++;
            } else{
                cost += total;
            }
            
        }
        if(people > peopleAns){
            peopleAns = people;
            costAns = cost;
        } else if(people == peopleAns){
            if(cost > costAns){
                peopleAns = people;
                costAns = cost;
            }
        }
    }
}