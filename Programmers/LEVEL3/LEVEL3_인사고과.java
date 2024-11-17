import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;
        int[] ho = scores[0];
        int s = ho[0] + ho[1];
        int[][] remains = Arrays.stream(Arrays.copyOfRange(scores, 1, scores.length)).filter(x->{
            return x[0]+x[1] > s;
        }).toArray(int[][]::new);


        HashMap<Integer, Integer> map = new HashMap<>();


        for (int i = 0; i < remains.length; i++) {
            int key = remains[i][0];
            int val = remains[i][1];

            if (map.get(key) != null) {
                int v = map.get(key);
                if (val > v) {
                    map.put(key, val);
                }
            } else{
                map.put(key, val);
            }
        }
        Set keyset = map.keySet();
        for (int i = 0; i < remains.length; i++) {
            int[] score = remains[i];
            if (score[0] > ho[0] && score[1] > ho[1]) {
                answer = -1;
                break;
            }
            boolean f = false;
            for (Object k : keyset) {
                int ke = (int) k;

                if(ke <= score[0]) continue;

                if (map.get(ke) > score[1]) {
                    f = true;
                    break;
                }
            }


            if(!f) answer++;

        }
        return answer == -1 ? -1 : answer+1;
    }
}