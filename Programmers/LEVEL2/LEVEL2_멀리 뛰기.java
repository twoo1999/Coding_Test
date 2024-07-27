import java.math.BigInteger;

class Solution {
    public long solution(int n) {
        long answer = 0;
        long one = n;
        long two = 0;

        while(true){
            long a = comb(one + two, two).mod(new BigInteger("1234567")).longValue();
            answer += a;
            one -= 2;
            two++;
            if(one < 0){
                break;
            }

        }
        return answer% 1234567;
        // System.out.println(answer);
    }
    
    static BigInteger comb(long n, long r){
        BigInteger a = factorial(n);
        BigInteger b = factorial(r);
        BigInteger c = factorial(n-r);
        return a.divide(b.multiply(c));
    }

    static BigInteger factorial(long x){
        if(x == 0 || x == 1){
            return new BigInteger("1");
        }
        BigInteger mul = new BigInteger("1");
        for(long i = 2; i <= x; i++){
            mul = mul.multiply(new BigInteger(String.valueOf(i)));
        }
        return mul;
    }
}