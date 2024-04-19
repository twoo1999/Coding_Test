import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int[] measures = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(mearsure->Integer.parseInt(mearsure)).toArray();
        Integer[] sorted = Arrays.stream(measures).boxed().toArray(Integer[]::new);
        Arrays.sort(sorted, Collections.reverseOrder());
        int cnt = sorted.length;

        System.out.println(sorted[0]*sorted[cnt-1]);



    }



}