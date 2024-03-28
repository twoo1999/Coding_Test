import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int cnt = Integer.parseInt(sc.nextLine());

        int[][] score = {{0,0,0},{0,0,0},{0,0,0}};


        for (int i = 0; i < cnt; i++) {
            int[] prefer = Arrays.stream(sc.nextLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();

            score[0][prefer[0]-1] += 1;
            score[1][prefer[1]-1] += 1;
            score[2][prefer[2]-1] += 1;
        }

        List<Integer> list = new ArrayList<>();


        int a = sum(score[0]);
        int b = sum(score[1]);
        int c = sum(score[2]);

        int max = 0;
        if (a > max) {
            max = a;
            list.add(0);
        }
        if (b > max) {
            max = b;
            list = new ArrayList<>(Arrays.asList(1));
        } else if (b == max) {
            list.add(1);
        }

        if (c > max) {
            max = c;
            list = new ArrayList<>(Arrays.asList(2));
        } else if (c == max) {
            list.add(2);
        }


        if (list.size() == 1) {
            System.out.println((list.get(0)+1) + " " + max);
        } else {
            int s = 2;
            int mmax = 0;

            while (list.size() != 1) {
                mmax = 0;
                List<Integer> newList = new ArrayList<>();
                for(int z = 0 ; z < list.size(); z++){
                    int i = list.get(z);
                    if(score[i][s] > mmax){
                        mmax = score[i][s];
                        newList = new ArrayList<>(Arrays.asList(i));
                    } else if (score[i][s] == mmax){
                        newList.add(i);
                    }
                }
                s--;
                if (s == -1) {
                   System.out.println("0" + " "+ max);
                   return;
                }
                list = newList;
            }
            System.out.println((list.get(0)+1)+ " "+  max);
        }
    }

    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += (i+1)*arr[i];
        }
        return sum;
    }
}
