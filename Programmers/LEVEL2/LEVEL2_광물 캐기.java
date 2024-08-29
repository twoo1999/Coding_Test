class Solution {
    static int min = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        dfs(picks[0], picks[1], picks[2], minerals, 0, 0);
        return min;
    }
    static void dfs(int dia, int iron, int stone, String[] minerals, int energy, int cnt){
        if (cnt*5 > minerals.length) {
            if (min > energy) {
                min = energy;
            }
            return;
        }

        if (dia == 0 && iron == 0 && stone == 0) {
            if (min > energy) {
                min = energy;
            }
            return;
        }

        int start = cnt * 5;
        int end = start + 5 > minerals.length ? minerals.length : start+5;
        if (dia != 0) { // 다이아 사용
            int sum = 0;
            for (int i = start; i < end; i++) {
                sum += 1;
            }
            dfs(dia - 1, iron, stone, minerals, energy+sum, cnt+1);
        }

        if (iron != 0) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                if(minerals[i].equals("diamond")) sum += 5;
                else sum += 1;
            }
            dfs(dia, iron - 1, stone, minerals, energy+sum, cnt+1);
        }

        if (stone != 0) {
            int sum = 0;
            for (int i = start; i < end; i++) {
                if(minerals[i].equals("diamond")) sum += 25;
                else if(minerals[i].equals("iron")) sum += 5;
                else sum += 1;
            }
            dfs(dia, iron, stone - 1, minerals, energy+sum, cnt+1);
        }


    }
}