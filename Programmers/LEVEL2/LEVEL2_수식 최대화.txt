import java.util.*;

class Solution {
    static long max = 0;
    public long solution(String expression) {
        long answer = 0;
        ArrayList<String> ops = new ArrayList<>();
        Set<String> opers = new HashSet<>();

        splitExpression(expression, ops, opers);

        String[] priority = new String[opers.size()];
        boolean[] check = new boolean[opers.size()];
        perm(new ArrayList<>(opers), ops, check, priority, opers.size(), 0);
        return max;
    }
    
    static void perm(ArrayList<String> opers, ArrayList<String> ops, boolean[] check, String[] priority, int n, int depth){
        if(n == depth){
            long val = Math.abs(cal(priority, (ArrayList<String>) ops.clone()));
            if(val > max){
                max = val;
            }
            return;
        }

        for(int i =0 ; i < n ; i++){
            if(check[i] != true){
                check[i] = true;
                priority[depth] = opers.get(i);
                perm(opers, ops, check, priority, n, depth+1);
                check[i] = false;
            }

        }
    }

    static long cal(String[] priority, ArrayList<String> ops){
        for (String p : priority) {
            ArrayList<String> temp = new ArrayList<>();
            while(ops.size() != 1){
                if(ops.contains(p)){
                    int idx = ops.indexOf(p);
                    long op1 = Long.parseLong(ops.get(idx-1));
                    long op2 = Long.parseLong(ops.get(idx+1));
                    long sum = 0;
                    if(p.equals("+")) {
                        sum = op1 + op2;
                    } else if(p.equals("-")){
                        sum = op1 - op2;
                    } else if(p.equals("*")){
                        sum = op1 * op2;
                    }
                    ops.remove(idx-1);
                    ops.remove(idx-1);
                    ops.remove(idx-1);
                    ops.add(idx-1, Long.toString(sum));

                } else{
                    break;
                }
            }
        }

        return Long.parseLong(ops.get(0));
    }
    static void splitExpression(String exp, ArrayList<String> ops, Set<String> opers){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0 ; i < exp.length(); i++){
            char e = exp.charAt(i);
            if(e >= '0' && e <= '9'){
                sb.append(e);
            } else {
                ops.add(sb.toString());
                ops.add(String.valueOf(e));
                sb.setLength(0);
                opers.add(String.valueOf(e));
            }
        }

        ops.add(sb.toString());
    }
}