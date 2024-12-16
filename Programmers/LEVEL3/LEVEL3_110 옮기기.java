class Solution {
    public String[] solution(String[] s) {
        String[] answer = {};



        answer = new String[s.length];
        for (int ii = 0 ; ii < s.length; ii++) {
            String str = s[ii];
            int start = 0;

            StringBuilder sb = new StringBuilder(str);

            while (true) {
                int idx = sb.indexOf("110", start);
                if(idx == -1){
                    break;
                }
                sb.replace(idx, idx+3, "");
                int zeroIdx = sb.indexOf("0", start);
                if (zeroIdx == -1) {
                    sb.insert(start, "110");
                    break;
                }
                while (zeroIdx != -1) {
                    boolean f = false;
                    for (int i = start; i <= zeroIdx; i++) {
                        if(start + 2 < zeroIdx){
                            sb.insert(i, "110");
                            start = i+3;
                            idx = sb.indexOf("110", start);
                            f = true;
                            break;
                        }
                    }
                    if(f){
                        break;
                    }

                    start = zeroIdx+1;
                    zeroIdx = sb.indexOf("0", start);
                }

                if(zeroIdx == -1){
                    sb.insert(start, "110");
                }



            }
            answer[ii] = sb.toString();
        }


        return answer;
    }
}