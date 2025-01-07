class Solution {
    public int solution(int n, int[] cores) {
        int answer = 0;

        long end = Integer.MAX_VALUE;
        long start = 0;
        while (start < end) {
            long mid = (end + start) / 2;
            if (check(n, mid, cores) >= n) { // 시간 부족
                end = mid;
            } else { // 시간 남음
                start = mid + 1;
            }

        }
        long proc = check(n, end, cores);
        while (true) {
            for (int i = cores.length - 1; i >= 0; i--) {
                if (end % cores[i] == 0) {
                    proc--;

                    if (proc == n - 1) {
                        return i+1;
                    }
                }
            }
            end--;
        }


    }

    static long check(int n, long time, int[] cores) {
        long proc = cores.length;

        for (int core : cores) {
            proc += (time / core);
        }


        return proc; //
    }
}