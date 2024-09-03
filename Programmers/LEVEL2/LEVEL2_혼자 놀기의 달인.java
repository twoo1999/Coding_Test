import java.util.*;

class Solution {
    static ArrayList<Integer> ar = new ArrayList<>();
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] check = new boolean[cards.length];
        for (int i = 0; i < cards.length; i++) {
            if(check[i]) continue;
            int num = cards[i]-1;
            check[i] = true;
            int cnt = 1;
            while (check[num] != true) {
                check[num] = true;
                num = cards[num]-1;
                cnt++;
            }
            ar.add(cnt);
        }
        if(ar.size() == 1) return 0;
        Collections.sort(ar, Collections.reverseOrder());
        int max = ar.get(0);
        int sc = ar.get(1);
        return max * sc;
    }
   


}