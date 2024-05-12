import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String target = sc.nextLine();
        int cnt = Integer.parseInt(sc.nextLine());
        int ans =0;
        int targetNum=0;
        if (cnt != 0) {
            String[] ban = sc.nextLine().split(" ");
            int close = 999999999;
            for(int i = 0; i < 999999; i++){
                String num = Integer.toString(i);
                boolean flag = false;
                for(int j = 0; j < num.length(); j++){
                    if(isContain(ban, num)){
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    int t = Integer.parseInt(target);
                    int d1 = Math.abs(t - i);
                    int d2 = Math.abs(t - close);

                    if(d1 < d2){
                        close = i;
                    }

                }

            }
            targetNum = Integer.parseInt(target);
            String c = Integer.toString(close);
            ans = c.length() + Math.abs(targetNum-close);

        } else{
            targetNum = Integer.parseInt(target);
            ans = target.length();
        }
        System.out.println(Math.abs(targetNum-100) > ans ? ans : Math.abs(targetNum-100));
    }

    static boolean isContain(String[] ban, String num){
        for (int i = 0; i < num.length(); i++) {

            boolean f = false;
            for(int j = 0; j < ban.length; j++){
                if(Character.toString(num.charAt(i)).equals(ban[j])){
                    f = true;
                    break;
                }
            }

            if(f){
                return true;
            }
        }
        return false;
    }
}