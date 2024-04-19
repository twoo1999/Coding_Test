import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int cnt = 9;
        int[] small = new int[cnt];
        for (int i = 0; i < cnt; i++) {
            small[i] = Integer.parseInt(sc.nextLine());
        }

        List<List<Integer>> combResult = getCombinations(small, 7);

        for (List<Integer> combination : combResult) {
            if (combination.stream().mapToInt((x -> x)).summaryStatistics().getSum() == 100) {
                Collections.sort(combination);
                for (int i = 0; i < combination.size(); i++) {
                    System.out.println(combination.get(i));
                }
                break;
            }
        }


    }


    public static List<List<Integer>> getCombinations(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        combine(result, tempList, nums, 0, k);
        return result;
    }
    public static void combine(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start, int k) {
        if (k == 0) {
            result.add(new ArrayList<>(tempList)); // tempList에 현재 조합을 추가
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]); // 현재 원소를 tempList에 추가
            combine(result, tempList, nums, i + 1, k - 1); // 재귀 호출로 다음 원소를 선택하도록 함
            tempList.remove(tempList.size() - 1); // 재귀 호출이 끝나면 현재 원소를 제거하고 다음 원소를 선택
        }
    }



}
