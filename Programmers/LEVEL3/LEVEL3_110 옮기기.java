class Solution {
    public String[] solution(String[] s) {
        String[] answer = {};



        answer = new String[s.length];

        for (int a = 0; a < answer.length; a++) {
            String ss = s[a];
            StringBuilder sb = new StringBuilder(ss);
            int idx = ss.indexOf("110");
            int cnt = 0;
            while (idx != -1) {
                sb.replace(idx, idx + 3, "");
                cnt++;
                idx = sb.indexOf("110");
            }


            for (int i = 2; i < sb.length(); i++) {
                if(sb.charAt(i) == '1' && sb.charAt(i-1) == '1' && sb.charAt(i-2) == '1'){
                    sb.insert(i-2, "110");
                    i+=2;
                    cnt--;
                }

                if (cnt == 0) {
                    break;
                }
            }

            if (cnt != 0) {
                int len = sb.length();
                String repeat = "110".repeat(cnt);
                if (len == 1) {
                    sb.insert(sb.charAt(0) == '0'?1 : 0, repeat);
                } else if (len == 2) {
                    String str = sb.toString();
                    if(str.equals("11")){
                        sb.insert(0, repeat);
                    } else if(str.equals("10")){
                        sb.insert(2, repeat);
                    } else if(str.equals("01")){
                        sb.insert(1, repeat);
                    } else if(str.equals("00")){
                        sb.insert(2, repeat);
                    }
                } else{
                    sb.insert(len, repeat);
                }
            }


            answer[a] = sb.toString();

        }


        return answer;
    }
}