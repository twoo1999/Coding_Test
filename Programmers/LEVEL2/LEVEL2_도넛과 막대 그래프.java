import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {};

        answer = new int[4];
        Map<Integer, Stack> inmap = new HashMap<>();
        Map<Integer, Stack> outmap = new HashMap<>();
        int newNode = 0;
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            if (outmap.get(start) == null) {
                Stack<Integer> st = new Stack<>();
                outmap.put(start, st);
            }
            outmap.get(start).push(end);


            if (inmap.get(end) == null) {
                Stack<Integer> st = new Stack<>();
                inmap.put(end, st);
            }
            inmap.get(end).push(start);
        }

        for (int key : outmap.keySet()) {
            int size = outmap.get(key).size();
            if(size > 2){
                newNode = key;
                break;
            } else if (size == 2) {
                if (inmap.get(key) == null) {
                    newNode = key;
                    break;
                }
            }
        }
        boolean[] check = new boolean[1000001];
        List<Integer> midList = outmap.get(newNode);
        for (int i = 0; i < midList.size(); i++) {
            int currNode = midList.get(i);
            boolean a = false;
            while (check[currNode] != true) {
                Stack<Integer> in = inmap.get(currNode);
                Stack<Integer> out = outmap.get(currNode);
                if (in != null && out != null) {
                    if (in.size() >= 2 && out.size() >= 2) {
                        answer[3]++;
                        a = true;
                        break;
                    }
                } else if (in != null && out == null) {
                    answer[2]++;
                    a = true;
                    break;
                } else if (in == null && out != null) {
                    answer[2]++;
                    a = true;
                    break;
                }
                check[currNode] = true;
                currNode = out.peek();
            }
            if (a != true) {
                answer[1]++;
            }
        }
        answer[0] = newNode;
        return answer;
    }
}