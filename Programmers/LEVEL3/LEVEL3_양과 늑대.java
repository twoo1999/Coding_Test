import java.util.*;
class Solution {
    public static class Node{
        Node left;
        Node right;
        int num;
        int animal;
        int s;
        int w;
        int cnt;
        public Node(int animal){
            this.animal = animal;
            this.s = 0;
            this.w = 0;
        }

    }
    public int solution(int[] info, int[][] edges) {
        int answer = 0;

        Node[] nodes = new Node[info.length];
        boolean[] check = new boolean[info.length];

        for (int i = 0; i < info.length; i++) {
            nodes[i] = new Node(info[i]);
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            int parent = edge[0];
            int child = edge[1];

            if (nodes[parent].left == null) {
                nodes[parent].left = nodes[child];
            } else{
                nodes[parent].right= nodes[child];
            }
            nodes[child].num = child;

        }

        int[] count = new int[info.length];
        Arrays.fill(count, Integer.MAX_VALUE);
        for (int i = 0; i < info.length; i++) {
            if(nodes[i].left != null) dfs(count, nodes[i].left, i, 1);
            if(nodes[i].right != null) dfs(count, nodes[i].right, i, 1);
            nodes[i].cnt = count[i];

            if(nodes[i].left == null && nodes[i].right == null && nodes[i].animal == 0) count[i] = 0;
        }


//        Queue<Integer> q = new LinkedList<>();
//        q.add(0);
//        HashSet<Integer> sheep = new HashSet<>();
//        HashSet<Integer> wolf = new HashSet<>();
        int[] a = {0, 0};
        int[] b = {0, 0};
        if(nodes[0].left != null) a = dfs1(nodes[0].left);
        if(nodes[0].right != null) b = dfs1(nodes[0].right);

        nodes[0].s = a[0] + b[0];
        nodes[0].w = a[1] + b[1];

        PriorityQueue<Node> pq = new PriorityQueue<>((x, y)->{


            int xx = x.s - x.w;
            int yy = y.s - y.w;

            if (xx != yy) {
                return yy - xx;
            }
            if (x.cnt != y.cnt) {
                return x.cnt - y.cnt;
            }

            return y.s - x.s;
        });


//        PriorityQueue<Node> pq = new PriorityQueue<>((x, y)->{
//            return x.w - y.w;
////            int yy = y.s - y.w;
////            int xx = x.s - x.w;
////
////            if (yy != xx) {
////                return (y.s - y.w) - (x.s - x.w);
////            } else{
////                return y.s - x.s;
////            }
//
//        });
////        Queue<Node> pq = new LinkedList<>();
        pq.add(nodes[0]);
        ArrayList<Node> ar = new ArrayList<>();
        int s = 0;
        int w = 0;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            int ww = w;
            int ss = s;


            if(curr.animal == 1) ww++;
            else ss++;

            if (ss > ww) {
                s = ss;
                w = ww;
                if(curr.left != null) pq.add(curr.left);
                if(curr.right != null) pq.add(curr.right);
                for (int i = 0; i < ar.size(); i++) {
                    pq.add(ar.get(i));
                }
                ar.clear();
            } else{
                ar.add(curr);
            }

        }
//
//
//        int w = 0;
//        int s = 0;
//
//        ArrayList<Node> ar = new ArrayList<>();
//        while (!pq.isEmpty()) {
////        while(cnt < 50){
//            Node curr = pq.poll();
//            int animal = curr.animal;
//
//
//            int ww = w;
//            int ss = s;
//
//
//            if(curr.s == 0) continue;
//            if(animal == 1) ww++;
//            else ss++;
//
//            if (ss > ww) {
//                s = ss;
//                w = ww;
//                if(curr.left != null) pq.add(curr.left);
//                if(curr.right != null) pq.add(curr.right);
//                for (int i = 0; i < ar.size(); i++) {
//                    pq.add(ar.get(i));
//                }
//                ar.clear();
//            } else{
//                ar.add(curr);
//            }
//
//
//
//        }
//        answer = s;
////        int prev = -1;
////        int size = 0;
////        while (prev != size) {
////            dfs(nodes[0].left, sheep, wolf);
////            dfs(nodes[0].right, sheep, wolf);
////            size = sheep.size();
////            prev = size;
////        }
////
////
////        System.out.println(prev);
////        System.out.println(size);

        answer = s;


        return answer;
    }

    //    static int[] dfs(Node node) {
//        int s = 0;
//        int w = 0;
//        int animal = node.animal;
//        if(animal == 1) w++;
//        else s++;
//
//        if(node.right == null && node.left == null){
//            node.w = w;
//            node.s = s;
//
//            return new int[]{s, w};
//        }
//
//
//
//
//        if(node.left != null) {
//            int[] r = dfs(node.left);
//            s += r[0];
//            w += r[1];
//        }
//        if(node.right != null) {
//            int[] r = dfs(node.right);
//            s += r[0];
//            w += r[1];
//        }
//
//        node.s = s;
//        node.w = w;
//
//        return new int[]{s, w};
//    }
    static int[] dfs1(Node node) {
        int s = 0;
        int w = 0;
        int animal = node.animal;
        if(animal == 1) w++;
        else s++;

        if(node.right == null && node.left == null){
            node.w = w;
            node.s = s;

            return new int[]{s, w};
        }




        if(node.left != null) {
            int[] r = dfs1(node.left);
            s += r[0];
            w += r[1];
        }
        if(node.right != null) {
            int[] r = dfs1(node.right);
            s += r[0];
            w += r[1];
        }

        node.s = s;
        node.w = w;

        return new int[]{s, w};
    }
    static void dfs(int[] count, Node node, int n, int cnt) {
        if (node.animal == 0) {
            count[n] = Math.min(cnt, count[n]);
        }

        if(node.right != null) dfs(count, node.right, n, cnt+1);
        if(node.left != null) dfs(count, node.left, n, cnt+1);
    }
}