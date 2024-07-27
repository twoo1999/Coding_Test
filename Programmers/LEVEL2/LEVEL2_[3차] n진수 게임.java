class Solution {
    static String[] value = {"0", "1", "2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int cnt = t * m;

        StringBuilder sb = new StringBuilder("");

        int number = 0;
        while(sb.length() < cnt){
            // String transedNum = transNum(n, number);
            String transedNum = Integer.toString(number, n);
            sb.append(transedNum);
            number++;
        }
        StringBuilder ans = new StringBuilder();
        for (int i = p ; i <= cnt; i+=m){
            ans.append(sb.charAt(i-1));
        }
        
        return ans.toString().toUpperCase();
    }
    
    static String transNum(int format, int num){
        if(num == 0){
            return "0";
        }
        int x = format;
        int y = num;
        StringBuilder s = new StringBuilder("");
        while(y > 1){
            int mod = y % x;
            y /= x;
            s.append(value[mod]);

        }

        if(y == 1){
            s.append(1);
        }

        return s.reverse().toString();
    }
}