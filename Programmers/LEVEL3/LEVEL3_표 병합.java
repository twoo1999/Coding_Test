import java.util.*;
class Solution {
    public String[] solution(String[] commands) {
        String[] answer = {};

        ArrayList<String> ans = new ArrayList<>();
        int[] parent = new int[50 * 50];
        String[] board = new String[50 * 50];
        Arrays.fill(board, "EMPTY");
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (String command : commands) {
            String[] cmd = command.split(" ");
            String method = cmd[0];
            if (method.equals("UPDATE")) {
                if (cmd.length == 4) { // UPDATE r c value
                    int r = Integer.parseInt(cmd[1])-1;
                    int c = Integer.parseInt(cmd[2])-1;
                    String v = cmd[3];
                    int n = r * 50 + c;

                    int root = find(parent, n);
                    for (int i = 0; i < parent.length; i++) {
                        if(root == find(parent, i)) board[i] = v;
                    }

                } else {
                    String value1 = cmd[1];
                    String value2 = cmd[2];

                    for (int i = 0; i < parent.length; i++) {
                        if(board[i].equals(value1)) board[i] = value2;
                    }
                }
            } else if (method.equals("MERGE")) {
                int r1 = Integer.parseInt(cmd[1])-1;
                int c1 = Integer.parseInt(cmd[2])-1;
                int r2 = Integer.parseInt(cmd[3])-1;
                int c2 = Integer.parseInt(cmd[4])-1;


                int n1 = r1 * 50 + c1;
                int n2 = r2 * 50 + c2;
                String v1 = board[n1];
                String v2 = board[n2];
                int root1 = find(parent, n1);
                int root2 = find(parent, n2);

                union(parent, root1, root2);
                int rRoot = find(parent, root1);
                String v = "EMPTY";
                if(v1.equals("EMPTY") && !v2.equals("EMPTY")){
                    v = v2;
                } else{
                    v = v1;
                }

                for (int i = 0; i < 2500; i++) {
                    if(parent[i] == rRoot || parent[i] == root1 || parent[i] == root2){
                        parent[i] = rRoot;
                        board[i] = v;
                    }
                }

            } else if (method.equals("UNMERGE")) {
                int r = Integer.parseInt(cmd[1])-1;
                int c = Integer.parseInt(cmd[2])-1;
                int n = r * 50 + c;

                int root = find(parent, n);
                String v = board[n];

                for (int i = 0; i < 2500; i++) {
                    if (find(parent, i) == root) {
                        board[i] = "EMPTY";
                        parent[i] = i;
                    }
                }

                board[n] = v;



            } else {
                int r = Integer.parseInt(cmd[1])-1;
                int c = Integer.parseInt(cmd[2])-1;
                int n = r * 50 + c;
                ans.add(board[n]);
            }
        }

        answer = new String[ans.size()];
        for(int i = 0 ; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    static void union(int[] parent, int x, int y) {
        int px = find(parent, x);
        int py = find(parent, y);

        if (px != py) {
            if(x > y){
                parent[x] = y;
            }
            else{
                parent[y] = x;
            }
        }

    }

    static int find(int[] parent, int n){
        if (parent[n] == n) {
            return n;
        }

        return find(parent, parent[n]);
    }
}