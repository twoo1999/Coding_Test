import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);


        int cnt = Integer.parseInt(sc.nextLine());
        int[] ans = new int[cnt];
        for(int i = 0 ; i < cnt; i++){
            int answer = 0;
            String[] nums = sc.nextLine().split(" ");
            int x = Integer.parseInt(nums[0]);
            int y = Integer.parseInt(nums[1]);
            int curr = x+1;
            int dis = 1;
            answer++;
            while(true){
                if(curr == y){
                    break;
                }
                int sum = (dis-1)*dis/2;
                int down = sum+dis;
                int up = sum + dis*2;
                int remain = y-curr;
                if(remain < down) dis--;
                else if(remain > up) dis++;

                curr += dis;
                answer++;
            }

            ans[i] = answer;
        }

        for(int i = 0 ; i < cnt; i++){
            System.out.println(ans[i]);
        }

    }
}