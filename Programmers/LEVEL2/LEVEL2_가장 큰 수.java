import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        String[] nums = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        Arrays.sort(nums, (x,y)->{
            String xy = x+y;
            String yx = y+x;
            return yx.compareTo(xy);
        });

        StringBuilder sb = new StringBuilder();

        for (String n : nums) {
            if(!(sb.toString().equals("") && n.equals("0"))){
                sb.append(n);    
            }
            
        }

        if(sb.toString().equals("")) sb.append("0");
        return sb.toString();
    }
    
    
    
}