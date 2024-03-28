import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static int findMaxLen(List<String> commands) {
        List<Integer> lens = commands.stream().map(command->command.length()).collect(Collectors.toList());
        return Collections.max(lens);
    }
    public static char getCharOfString(String str, int idx){
        return str.charAt(idx);

    }
    public static boolean checkSameChar(char[] chars){
        for (int i = 0; i < chars.length-1; i++) {
            if (chars[i] != chars[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static char[] changeListToArr(List<Character> chars){
        char[] cs = new char[chars.size()];
        for(int i = 0 ; i < chars.size(); i++){
            cs[i] = chars.get(i);
        }
        return cs;

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int commandCnt = Integer.parseInt(br.readLine());
        List<String> commands = new ArrayList<>();
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < commandCnt; i++) {
            commands.add(br.readLine());
        }
        int maxLen = findMaxLen(commands);
        for (int i = 0; i < maxLen; i++) {
            List<Character> c = new ArrayList<>();
            for(int j = 0; j < commandCnt; j++){
                try {
                    c.add(getCharOfString(commands.get(j), i));
                } catch (Exception e){
                    result.add('?');
                    break;
                }
            }
            if(checkSameChar(changeListToArr(c))){
                result.add(c.get(0));
            }
            else{
                result.add('?');
            }
        }

        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining()));
    }



}