import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long L = 0;
        long O = 0;
        long V = 0;
        long E = 0;
        long max = -1;
        String result = "";
        String name = br.readLine();

        int cnt = Integer.parseInt(br.readLine());
        L = name.chars().filter(c-> c == 'L').count();
        O = name.chars().filter(c-> c == 'O').count();
        V = name.chars().filter(c-> c == 'V').count();
        E = name.chars().filter(c-> c == 'E').count();

        List<String> list = new ArrayList<>();

        for (int i = 0; i < cnt; i++) {
            list.add(br.readLine());
        }

        List<String> sorted = list.stream().sorted().collect(Collectors.toList());


        for (int i = 0; i < cnt; i++) {
            String teamName = sorted.get(i);
            long re = cal(L + calCnt(teamName,'L'), O + calCnt(teamName, 'O'), V + calCnt(teamName, 'V'), E + calCnt(teamName, 'E'));
            if (re > max) {
                max = re;
                result = teamName;
            }
        }
        System.out.println(result);

    }

    public static long calCnt(String name, char ch) {
        return name.chars().filter(c->c==ch).count();
    }
    public static long cal(long L, long O, long V, long E) {
        return ((L + O) * (L + V) * (L + E) * (O + V) * (O + E) * (V + E)) % 100;
    }



}
