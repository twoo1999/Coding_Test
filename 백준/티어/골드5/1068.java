import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int answer = 0;
        ArrayList<Integer> ban = new ArrayList<>();
        int cnt = Integer.parseInt(sc.nextLine());
        int[] node = new int[cnt];
        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.fill(node, 0);
        boolean[] check = new boolean[cnt];
        int remove = Integer.parseInt(sc.nextLine());
        ban.add(remove);
        node[remove] = -1;

        for (int i = 0; i < cnt; i++) {
            if (nums[i] == -1) {
                check[i] = true;
            }
        }

        while (true) {
            for (int i = 0; i < cnt; i++) {
                if (check[i] != true) {
                    int parent = nums[i];
                    if (check[parent] == true) {
                        if (node[parent] == -1) {
                            node[i] = -1;
                        } else{
                            if (node[i] != -1) {
                                node[parent]++;
                            }

                        }
                        check[i] = true;

                    }
                }
            }

            if (isCheck(check)) {
                break;
            }
        }

        for (int i = 0; i < node.length; i++) {
            if (node[i] == 0) {
                answer++;
            }
        }
        System.out.println(answer);
    }
    static boolean isCheck(boolean[] check){
        for (int i = 0; i < check.length; i++) {
            if (check[i] != true) {
                return false;
            }
        }
        return true;
    }
}

