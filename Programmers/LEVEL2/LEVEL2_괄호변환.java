class Solution {
    public String solution(String p) {
        String answer = "";
        return func(p);
    }
    String func(String bracket){
        if(bracket.equals("")){
            return "";
        }
        String[] sp  = splitBracket(bracket);
        String u = sp[0];
        String v = sp[1];
        if(isCorrect(u)){
            return u + func(v);
        }else{
            return "(" + func(v) + ")" +  reverseBracket(u.substring(1, u.length()-1));
        }

    }
    String reverseBracket(String bracket){
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < bracket.length(); i++){
            sb.append(bracket.charAt(i) == '(' ? ')' : '(');
        }
        return sb.toString();
    }
    String[] splitBracket(String bracket){
        int n = 0;
        for(int i = 0 ; i < bracket.length(); i++){
            n += (bracket.charAt(i) == '(' ? 1 : -1);
            if(n == 0){
                return new String[]{bracket.substring(0, i+1), bracket.substring(i+1, bracket.length())};
            }
        }
        return new String[]{bracket, ""};

    }

    boolean isCorrect(String bracket){
        int re = 0;
        for(int i = 0 ; i < bracket.length(); i++){
            re += (bracket.charAt(i) == '(' ? 1 : -1);
            if(re < 0) return false;
        }

        return re == 0;

    }
}