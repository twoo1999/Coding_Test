import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();

        int size = nums[0];
        int cnt = nums[1];

        List<Integer> list = Arrays.stream(br.readLine().split(",")).map(x -> Integer.parseInt(x)).collect(Collectors.toList());

        for (int i = 0; i < cnt; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j= 0; j < list.size()-1; j++){
                temp.add(list.get(j+1) - list.get(j));
            }
            list = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            sb.append(',');
        }
        String str = sb.toString();
        System.out.println(str.substring(0, str.length()-1));

    }

}
