import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int max1 = 0;
        String mm = edit(m);
        int d = 0;
        for(String musicinfo : musicinfos){
            String[] info = musicinfo.split(",");
            int diff = time(info[1]) - time(info[0]);
            String title = info[2];
            String sheet = edit(info[3]);
            // System.out.println(sheet);
            // System.out.println(m);
            StringBuilder sb = new StringBuilder("");
            for(int i = 0 ; i < diff; i++){
                sb.append(String.valueOf(sheet.charAt(i%sheet.length())));
            }
            
            if(sb.indexOf(mm) >= 0){
                if(diff > d){
                    answer = title;
                    d = diff;
                }
            }
            
            
            
        }
        return answer;
    }
    static int time(String t){
        String[] tt = t.split(":");
        return Integer.parseInt(tt[0])*60 + Integer.parseInt(tt[1]);
    }
    static String edit(String sheet){
        sheet = sheet.replaceAll("C#", "1");
        sheet = sheet.replaceAll("D#", "2");
        sheet = sheet.replaceAll("F#", "3");
        sheet = sheet.replaceAll("G#", "4");
        sheet = sheet.replaceAll("A#", "5");
        sheet = sheet.replaceAll("B#", "6");
        return sheet;        
    }
}