import java.util.regex.*;
import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        String regx = "[^\\d]+|[\\d]+";
        Pattern p = Pattern.compile(regx);
        Arrays.sort(files, (x, y)->{
            Matcher xMatcher = p.matcher(x.toLowerCase());
            Matcher yMatcher = p.matcher(y.toLowerCase());
            xMatcher.find();
            yMatcher.find();
            int compareHead = xMatcher.group().compareTo(yMatcher.group());
            
            xMatcher.find();
            yMatcher.find();
            int compareNum = Integer.parseInt(xMatcher.group()) - Integer.parseInt(yMatcher.group());
            // return compareHead;
            return compareHead == 0 ? compareNum : compareHead;
        });
        
        answer = files;
//         String[] answer = new String[files.length];
//         String[][] name = new String[files.length][3];
//         String headReg = "[^\\d]+";
//         String numReg = "[\\d]+";
//         Pattern headPattern = Pattern.compile(headReg);
//         Pattern numPattern = Pattern.compile(numReg);
        
//         for(int i = 0; i < files.length; i++){
//             String file = files[i];
//             Matcher headMatcher = headPattern.matcher(file);
//             Matcher numMatcher = numPattern.matcher(file);
//             numMatcher.find();    
//             headMatcher.find();
//             String head = headMatcher.group();
//             String num = numMatcher.group();
//             String tail = file.substring(head.length() + num.length());
//             name[i][0] = head;
//             name[i][1] = num;
//             name[i][2] = tail;
//         }
        
        
//         Arrays.sort(name, (x, y)->{
//             String xHead = x[0].toLowerCase();
//             String yHead = y[0].toLowerCase();
//             int xNum = Integer.parseInt(x[1]);
//             int yNum = Integer.parseInt(y[1]);
            
//             int compareHead = xHead.compareTo(yHead);
//             int compareNum = xNum - yNum;
//             return compareHead == 0 ? compareNum : compareHead;
//         });
        
        
        
//         for(int i = 0 ; i < files.length; i++){
//             answer[i] = name[i][0] + name[i][1] + name[i][2];
//         }
// //         for(String n : answer){
// //             System.out.println(n);
// //         }
            
            
        
        
        
        
        
        
        
        return answer;
    }
}