import java.util.*;
class Solution {
    static public class Node{
        int x;
        int y;
        int num;
        Node left;
        Node right;

        public Node(int[] info) {
            this.x = info[0];
            this.y = info[1];
            this.num = info[2];
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        int[][] nodeInfo = new int[nodeinfo.length][3];

        for (int i = 0 ; i < nodeinfo.length; i++) {
            int[] node = nodeinfo[i];
            nodeInfo[i][0] = node[0];
            nodeInfo[i][1] = node[1];
            nodeInfo[i][2] = i+1;
        }
        Arrays.sort(nodeInfo, (x, y)->{
            if(x[1] != y[1]) return y[1] - x[1]; else return x[0]-y[0];
        });
        ArrayList<int[]> ar = new ArrayList<>();
        Node root = new Node(nodeInfo[0]);

        for (int i = 1 ; i < nodeInfo.length; i++) {
            int[] info = nodeInfo[i];
            appendNode(root, new Node(info));
        }

        List<Integer> preorder = new ArrayList<>();
        preorder(root, preorder);
        List<Integer> postorder = new ArrayList<>();
        postorder(root, postorder);

        answer = new int[2][nodeinfo.length];
        answer[0] = preorder.stream().mapToInt(Integer::intValue).toArray();
        answer[1] = postorder.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
    static void appendNode(Node n, Node c) {
        if(n.x > c.x){
            if(n.left == null){
                n.left = c;
            } else{
                appendNode(n.left, c);
            }
        } else{
            if (n.right == null) {
                n.right = c;
            } else {
                appendNode(n.right, c);
            }
        }
    }
    static void preorder(Node node, List<Integer> order){
        if(node != null){
            order.add(node.num);
            preorder(node.left, order);
            preorder(node.right, order);
        }
    }

    static void postorder(Node node, List<Integer> order){
        if(node != null){
            postorder(node.left, order);
            postorder(node.right, order);
            order.add(node.num);
        }
    }
}