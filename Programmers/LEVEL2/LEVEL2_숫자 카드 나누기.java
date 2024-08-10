class Solution {
    public int solution(int[] arrayA, int[] arrayB) {

        
        int answer1 = 0;
        int a = arrayA[0];
        for (int i = 1; i < arrayA.length; i++) {
            a = gcd(a, arrayA[i]);
        }

        while (a > 1) {

            for (int i = 0 ; i < arrayB.length; i++) {
                if(arrayB[i]%a == 0) break;
                if(i == arrayB.length-1) answer1 = a;
            }
            if(answer1 != 0) break;
            for (int i = 2; i <= a ; i++) {
                if(a % i == 0){
                    a /= i;
                    break;
                }
            }
        }

        int b = arrayB[0];
        for (int i = 1; i < arrayB.length; i++) {
            b = gcd(b, arrayB[i]);
        }
        int answer2 = 0;
        while (b > 1) {

            for (int i = 0 ; i < arrayA.length; i++) {
                if(arrayA[i]%b == 0) break;
                if(i == arrayA.length-1) answer2 = b;
            }
            if(answer2 != 0) break;
            for (int i = 2; i <= b; i++) {
                if(b % i == 0) {
                    b /= i;
                    break;
                }
            }
        }
        return answer1 > answer2 ? answer1 : answer2;
    }
    static int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}