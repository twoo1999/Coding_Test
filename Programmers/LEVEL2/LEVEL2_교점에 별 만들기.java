import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        String[] answer = {};
        ArrayList<int[]> ar = new ArrayList<>();
        ArrayList<Integer> ylist = new ArrayList<>();
        ArrayList<Integer> xlist = new ArrayList<>();
        for (int i = 0; i < line.length-1; i++) {
            for (int j = i+1; j < line.length; j++) {
                int[] a = line[i];
                int[] b = line[j];

                int A = a[0];
                int B = a[1];
                int E = a[2];

                int C = b[0];
                int D = b[1];
                int F = b[2];

                long n = (long)A * (long)D - (long)B * (long)C;
                if(n == 0) continue;
                long m1 = ((long)B * (long)F - (long)E * (long)D);
                long m2 = ((long)E * (long)C - (long)A * (long)F);
                if(m1 % n != 0) continue;
                if(m2 % n != 0) continue;
                int x = (int)(m1 / n);
                int y = (int)(m2 / n);
                ylist.add(y);
                xlist.add(x);
                ar.add(new int[]{y, x});
            }

        }
        Collections.sort(ylist);
        Collections.sort(xlist);
        while (xlist.get(xlist.size() - 1) - xlist.get(0) > 1000) {
            xlist.remove(xlist.size() - 1);
        }
        while (ylist.get(ylist.size() - 1) - ylist.get(0) > 1000) {
            ylist.remove(ylist.size() - 1);
        }
        int maxx = xlist.get(xlist.size()-1);
        int minx = xlist.get(0);
        int maxy = ylist.get(ylist.size() - 1);
        int miny = ylist.get(0);
        int cols = maxy-miny+1;
        int rows = maxx-minx+1;
        char[][] chars = new char[cols > 1000 ? 1000 : cols][rows > 1000 ? 1000 : rows];
        for (int i = 0; i < chars.length; i++) {
            Arrays.fill(chars[i], '.');
        }

        for (int[] a : ar) {
            int y = a[0] - miny;
            int x = a[1] - minx;
            if(y > 1000 || x > 1000)continue;
            chars[a[0]-miny][a[1]-minx] = '*';
        }

        answer = new String[chars.length];

        for (int i = 0; i < chars.length; i++) {
            answer[chars.length-i-1] = new String(chars[i]);
        }
        return answer;
    }
}