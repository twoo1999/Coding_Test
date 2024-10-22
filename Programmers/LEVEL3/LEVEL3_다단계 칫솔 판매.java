import java.util.*;

class Solution {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = {};
        answer = new int[enroll.length];

        HashMap<String, String> map = new HashMap<>();
        HashMap<String, Integer> idxMap = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], referral[i]);
            idxMap.put(enroll[i], i);
        }


        for (int i = 0; i < seller.length; i++) {
            String name = seller[i];
            int cost = amount[i]*100;

            while (!name.equals("-")) {
                int idx = idxMap.get(name);
                int x = cost / 10;
                int y = cost - x;
                answer[idx] += y;
                cost /= 10;
                name = map.get(name);

                if(cost == 0) break;
            }
        }
        return answer;
    }
}