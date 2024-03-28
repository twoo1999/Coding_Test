import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int stdCnt = Integer.parseInt(br.readLine());
//        int[][] record = new int[stdCnt][];
        List<List<Integer>> record = new ArrayList<>();
//        List<List<Integer>> std = new ArrayList<>();
        int[][] std = new int[stdCnt][stdCnt];
        for (int i = 0; i < stdCnt; i++) {
            record.add(Arrays.stream(br.readLine().split(" ")).map(x->Integer.parseInt(x)).collect(Collectors.toList()));
        }

        for (int i = 0; i < stdCnt; i++) {
            for (int j = 0; j < 5; j++) {

                int classNum = record.get(i).get(j);
                final int jj = j;
                List<Integer> yearInfo = record.stream().map(line->line.get(jj)).collect(Collectors.toList());
                List<Integer> sameInfo = func1(yearInfo, i, classNum, stdCnt);
                func2(std, sameInfo, i);

            }
        }

        long max = 0;
        int result = 0;
        for (int i = 0; i < stdCnt; i++) {

            long cur = Arrays.stream(std[i]).filter(x->x==1).count();
            if (cur > max) {
                max = cur;
                result = i;
            }
        }
        System.out.println(result+1);
//        for (int i = 0; i < stdCnt; i++) {
//            for (int j = 0; j < stdCnt; j++) {
//                System.out.print(std[i][j]);
//                System.out.print(" ");
//            }
//            System.out.println();
//        }

    }

    public static void func2(int[][] std, List<Integer> sameInfo, int me) {
        for (int i : sameInfo) {
            std[me][i] = 1;
        }
    }
    public static List<Integer> func1(List<Integer> record, int me, int classNum, int peopleNum) {
        List<Integer> same = new ArrayList<>();
        for (int i = 0; i < peopleNum; i++) {
            if (i != me) {
                if(classNum == record.get(i)){
                    same.add(i);
                }
            }
        }

        return same;
    }

}
