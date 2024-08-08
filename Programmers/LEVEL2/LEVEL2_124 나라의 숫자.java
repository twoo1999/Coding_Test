class Solution {
    public String solution(int n) {
        String answer = "";
        int[] numbers = {1, 2, 4};
        int digit = 1;
        int max = 3;
        int min = 0;
        while(n > max){
            max += Math.pow(3, ++digit);
        }
        StringBuilder sb = new StringBuilder("");
        while (digit > 0) {

            min = (int) (max - Math.pow(3, digit == 1 ? 1 : digit));
            int range = (max - min) / 3;
            for (int i = 1; i <= 3; i++) {
                if (i == 3) {
                    sb.append(numbers[2]);
                    min = min + range*i;
                    break;
                }
                if (n <= min + range * i) {
                    max = min + range*(i);
                    sb.append(numbers[i-1]);
                    break;
                }
            }
            digit--;
        }
        return sb.toString();
    }
}