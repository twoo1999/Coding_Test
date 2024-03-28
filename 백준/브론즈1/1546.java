import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        List<Double> scores = Arrays.stream(br.readLine().split(" ")).map(x->Double.parseDouble(x)).collect(Collectors.toList());

        Collections.sort(scores, Collections.reverseOrder());

        Double sum = 0.0;
        Double max = scores.get(0);
        for (int i = 0; i < scores.size(); i++) {
            sum += scores.get(i)/max*100;
        }

        System.out.println((sum)/cnt);


    }

}

