import java.util.;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        QueueString q = new LinkedList();
        HashMapString, Integer m = new HashMap();
        HashSetString s = new HashSet(Arrays.asList(gems));
        int start = 0;
        int l = Integer.MAX_VALUE;
        int tstart = 0;
        for(int i = 0 ; i  gems.length; i++){
           String cur = gems[i];

            m.put(cur, m.getOrDefault(cur, 0) + 1);
            q.offer(cur);
            while(true){
                String f = q.peek();
                if(m.get(f)  1){
                    m.put(f, m.get(f) -1);
                    q.poll();
                    
                    tstart++;
                } else{
                    break;
                }
            }
            
            if(m.size() == s.size() && l  q.size()) {
                l = q.size();
                start = tstart;
            }
        }
        
        
        
         return new int[]{start + 1, start + l};
    }
    
 
}