import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String[] ns = sc.nextLine().split(" ");
        int re = 0;
        int small = Integer.parseInt(ns[0]);
        int big = Integer.parseInt(ns[1]);
        boolean[] isPrime = new boolean[big + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= big; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= big; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();

        for (int i = 2; i < big + 1; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        boolean[] nums = new boolean[big + 1];
        Arrays.fill(nums, false);

        for (int i = small; i <= big; i++) {
            if (!nums[i]) {
                nums[i] = true;
                List<Integer> list = new ArrayList<>();
                int num = i;
                for (int j = 0 ;j < primes.size(); j++) {
                    int z = primes.get(j);
                    while (num % z == 0) {
                        num /= z;
                        list.add(z);
                    }
                }

                int cnt = list.size();
                if (isPrime[cnt]) {
                    re++;
                }

                int s = i;
                int mul = 2;
                while (true) {
                    int val =s * mul;
                    if (val < big) {
                        if (!nums[val]) {
                            if (isPrime[mul]) {
                                nums[val] = true;
                                if (isPrime[cnt + 1]) {
                                    re++;
                                }
                            }
                        }


                    } else{
                        break;
                    }
                    mul++;
                }
            }
        }



        System.out.println(re);


    }
}