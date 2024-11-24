import java.util.*;
class Solution {
    public static class Node{
        Node left;
        Node right;
        int num;
        int animal;
        Set<Integer> hidewolf;
        int depth;
        public Node(int animal){
            this.animal = animal;
            this.hidewolf = new HashSet<>();
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
            nodes[child].depth = nodes[parent].depth+1;
            nodes[child].num = child;

        }

        int len = info.length;
        int cnt = 0;

        int sheep = 0;
//        int wolf = 0;
        Set<Integer> wolf = new HashSet<>();
//        Queue<Node> q = new LinkedList<>();
        PriorityQueue<Node> q = new PriorityQueue<>((x, y)->{
            if (x.hidewolf.size() != y.hidewolf.size()) {
                return  x.hidewolf.size()-y.hidewolf.size();
            } else{
                return x.depth - y.depth;
            }

        });
        q.add(nodes[0]);
        Set<Integer> s = new HashSet<>();
        while (!q.isEmpty()) {
            Node curr = q.poll();

            if(curr == nodes[0]){
                sheep++;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
                continue;
            }

            if (curr.animal == 0) {

                if(getSize(curr.hidewolf, wolf) >= sheep){ // 늑대가 많은 경우
                    q.add(curr);
                    int size = s.size();
                    s.add(curr.num);
                    if(s.size() == size){
                        break;
                    }
                } else { // 양이 더 많은 경우
                    s.clear();
                    sheep++;
                    wolf.addAll(curr.hidewolf);
                    if(curr.left != null) q.add(curr.left);
                    if(curr.right != null) q.add(curr.right);
                }
            } else {
                if(curr.left != null){
                    curr.left.hidewolf.add(curr.num);
                    curr.left.hidewolf.addAll(curr.hidewolf);
                    q.add(curr.left);
                }
                if(curr.right != null){
                    curr.right.hidewolf.add(curr.num);
                    curr.right.hidewolf.addAll(curr.hidewolf);
                    q.add(curr.right);
                }
            }
        }

        answer = sheep;


        return answer;
    }
    static int getSize(Set<Integer> s1, Set<Integer> s2) {
        Set<Integer> s = new HashSet<>(s1);
        s.addAll(s2);
        return s.size();
    }
}