import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static Map<Integer, Integer> func1(Map<Integer, Integer> map, Integer num) {
        Map<Integer, Integer> result = new HashMap<>();

        int N = num;
        int i = 2;
        while (N != 1) {
            if (N % i == 0) {
                N /= i;
                if (result.containsKey(i)) {
                    result.put(i, result.get(i) + 1);
                }else {
                    result.put(i, 1);
                }
            }else{
                i++;
            }
        }


        result.forEach((key, value) -> map.merge(key, value, (v1, v2) -> v1 > v2 ? v1 : v2));
        return map;
    }

    public static Integer func2(Map<Integer, Integer> map) {
        int result = 1;
        for (Integer key : map.keySet()) {
            result *= Math.pow(key, map.get(key));
        }
        return result;
    }
    public static List<Integer> cal(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.size() - 2; i++) {
            for (int j = i + 1; j < numbers.size() - 1; j++) {
                for (int z = j + 1; z < numbers.size(); z++) {

                    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                    map = func1(map, numbers.get(i));
                    map = func1(map, numbers.get(j));
                    map = func1(map, numbers.get(z));
                    list.add(func2(map));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> numbers = Arrays.stream(br.readLine().split(" ")).map(num -> Integer.parseInt(num)).collect(Collectors.toList());
        System.out.println(Collections.min(cal(numbers)));
    }


}