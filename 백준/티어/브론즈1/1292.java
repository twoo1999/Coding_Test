import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        int start = Integer.parseInt(nums[0]);
        int end = Integer.parseInt(nums[1]);
        int result = 0;
        int startNum = findStartNum(start);
        int endNum = findStartNum(end);
        int N = startNum;
        int s = start;
        while (N <= endNum) {
            int finishIdx = findEndIdx(N);
            int range;
            if (N == endNum) {
                range= end - s+1;
            }
            else{
                range = finishIdx-s;
            }
            result += N * range;
            N++;
            s = finishIdx;
        }

        System.out.println(result);
    }

    public static int findStartIdx(int n) {
        return (n * (n-1) / 2) + 1;
    }

    public static int findEndIdx(int n) {
        return findStartIdx(n + 1);
    }

    public static int findStartNum(int start) {
        for (int i = 1; i <= start; i++) {
           int startNum =  (i * (i-1) / 2)+1;
           int endNum = ((i+1)*i / 2)+1;
           if(startNum<=start && endNum > start){
               return i;
           }
        }
        return 0;
    }


}
