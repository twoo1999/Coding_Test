import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int ans = 0;
        Stack<int[]> s = new Stack<>();
        int[] arr = new int[30];
        int level = 0;
        int max = 0;

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(' || c == '[') s.push(new int[]{c, level++});
            else {
                if(s.isEmpty()) {
                    arr[0] = 0;
                    break;
                }
                if(c == ')' && s.peek()[0] == '('){
                    int[] p = s.pop();
                    int l = p[1];
                    if(arr[l+1] != 0){
                        arr[l] += 2 * arr[l+1];
                        arr[l+1] = 0;
                    } else{
                        arr[l] += 2;
                    }
                    level--;
                } else if(c == ']' && s.peek()[0] == '['){

                    int[] p = s.pop();
                    int l = p[1];
                    if(arr[l+1] != 0){
                        arr[l] += 3 * arr[l+1];
                        arr[l+1] = 0;
                    } else{
                        arr[l] += 3;
                    }
                    level--;
                }
            }

            max = Math.max(max, level);

        }

        ans = arr[0];
        for (int i = 1; i <= max; i++) {
            if(arr[i] != 0) ans = 0;
        }
        System.out.println(ans);
    }


}