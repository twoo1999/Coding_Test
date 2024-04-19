import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());

        for (int i = 0; i < cnt; i++) {
            String a = br.readLine();
            List<Integer> num = Arrays.stream(br.readLine().split(" ")).map(x->Integer.parseInt(x)).collect(Collectors.toList());

            int s = num.get(0);
            int b = num.get(1);
            List<Integer> listS = Arrays.stream(br.readLine().split(" ")).map(x->Integer.parseInt(x)).collect(Collectors.toList());
            List<Integer> listB = Arrays.stream(br.readLine().split(" ")).map(x->Integer.parseInt(x)).collect(Collectors.toList());

            Collections.sort(listS, Collections.reverseOrder());
            Collections.sort(listB, Collections.reverseOrder());


            Stack<Integer> stackS = new Stack<>();
            stackS.addAll(listS);
            Stack<Integer> stackB = new Stack<>();
            stackB.addAll(listB);

            while (stackS.size() != 0 && stackB.size() != 0) {
                if(stackS.peek() >= stackB.peek()){
                    stackB.pop();
                }else{
                    stackS.pop();
                }
            }

            if (stackS.size() != 0) {
                System.out.println('S');
            }
            else if( stackB.size() != 0){
                System.out.println('B');
            }
            else{
                System.out.println('C');
            }
        }
    }

}
