class Solution {
    static int cnt;
    public class Node{
        Node left;
        Node right;
        int data;

        public Node() {
            data = -1;
            left = null;
            right = null;
        }
    }
    public int[] solution(long[] numbers) {


        int[] answer = new int[numbers.length];
        for (int idx = 0; idx < answer.length; idx++) {
            long n = numbers[idx];

            cnt = 0;
            String bin = Long.toBinaryString(n);
            int nodeCnt = bin.length();

            int lv = 1;
            while (Math.pow(2, lv) - 1 < nodeCnt) {
                lv++;
            }

            Node root = new Node();
            Node[] nodes = new Node[(int) Math.pow(2, lv)];

            for (int i = 0; i < nodes.length; i++) {
                nodes[i] = new Node();
            }
            nodes[1] = root;

            for (int i = 1; i < Math.pow(2, lv-1); i++) {
                nodes[i].left = nodes[i*2];
                nodes[i].right = nodes[i*2+1];
            }


            if (nodeCnt < Math.pow(2, lv) - 1) {
                bin = padLeft(bin, (int)Math.pow(2, lv) - 1);
            }

            int[] d = bin.chars().map(x -> x - '0').toArray();

            inOrder(root, d);
            boolean f = false;
            for (int i = 1; i < nodes.length; i++) {
                if (nodes[i].data == 0) {
                    if (nodes[i].left != null && nodes[i].left.data == 1) {
                        f = true;
                        break;
                    }
                    if (nodes[i].right != null && nodes[i].right.data == 1) {
                        f = true;
                        break;
                    }
                }
            }

            if (f == true) {
                answer[idx] = 0;
            } else{
                answer[idx] = 1;
            }
        }

        return answer;
    }
    public static String padLeft(String bin, int n) {
        int diff = n - bin.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < diff; i++) {
            sb.append(0);
        }
        sb.append(bin);
        return sb.toString();
    }

    public static void inOrder(Node node, int[] d) {
        if (node != null) {
            if(node.left != null) inOrder(node.left, d);
            node.data = d[cnt++];
            if(node.right != null) inOrder(node.right, d);
        }
    }
}