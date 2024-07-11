class Solution {
    public int solution(String s) {
        int answer = s.length();


        for(int range = 1; range <= s.length()/2; range++){
            int cnt = 1;
            String word = s.substring(0, range);
            String sh = "";
            for(int i = range; i < s.length(); i+=range){
                if(i+range > s.length()){
                    sh += cnt != 1 ? String.valueOf(cnt) + word : word;
                    sh += s.substring(i, s.length());
                    cnt = 0;
                    break;
                }
                String temp = s.substring(i, i+range);
                if(temp.equals(word)){
                    cnt++;
                } else{
                    sh += cnt != 1 ? String.valueOf(cnt) + word : word;
                    word = temp;
                    cnt = 1;
                }
            }
            if(cnt != 0){
                sh += cnt != 1 ? String.valueOf(cnt) + word : word;
            }
            if(sh.length() < answer){
                answer = sh.length();
            }

        }



        return answer;
    }
}