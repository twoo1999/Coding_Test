class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";


        int cnt = 0;
        char[] chars = new char[k];

        while (cnt != k) {

            // d 밑으로 x+1

            int dnx = x + 1;
            int dny = y;

            int lnx = x;
            int lny = y - 1;

            int rnx = x;
            int rny = y + 1;

            int unx = x - 1;
            int uny = y;


            if (!(dnx > n || dnx <= 0 || dny > m || dny <= 0)) {
                int remain = Math.abs(dnx - r) + Math.abs(dny - c); // 남은 길
                if(remain <= k - cnt){
                    chars[cnt++] = 'd';
                    x = dnx;
                    y = dny;
                    continue;
                }
            }

            if (!(lnx > n || lnx <= 0 || lny > m || lny <= 0)) {
                int remain = Math.abs(lnx - r) + Math.abs(lny - c); // 남은 길
                if(remain <= k - cnt){
                    chars[cnt++] = 'l';
                    x = lnx;
                    y = lny;
                    continue;
                }
            }


            if (!(rnx > n || rnx <= 0 || rny > m || rny <= 0)) {
                int remain = Math.abs(rnx - r) + Math.abs(rny - c); // 남은 길
                if(remain <= k - cnt){
                    chars[cnt++] = 'r';
                    x = rnx;
                    y = rny;
                    continue;
                }
            }

            if (!(unx > n || unx <= 0 || uny > m || uny <= 0)) {
                int remain = Math.abs(unx - r) + Math.abs(uny - c); // 남은 길
                if(remain <= k - cnt){
                    chars[cnt++] = 'u';
                    x = unx;
                    y = uny;
                    continue;
                }
            }

            cnt++;



        }


        answer = x == r && y == c ? new String(chars) : "impossible";
        return answer;
    }


}