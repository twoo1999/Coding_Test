class Solution {
    static int zero = 0;
    static int one = 0;
    public int[] solution(int[][] arr) {
        int[] answer = {};
        func(arr, 0, arr[0].length-1, 0, arr.length-1);
        return new int[]{zero, one};
    }
    static void func(int[][] arr, int xs, int xe, int ys, int ye){
        if(xe == xs){
            if(arr[ys][xs] == 1) one++;
            else zero++;
            return;
        }

        int c = check(arr, xs, xe, ys, ye);
        if(c != -1){
            if(arr[ys][xs] == 1) one++;
            else zero++;
            return;
        } else{
            int xn = (xs+xe)/2;
            int yn = (ys+ye)/2;
            func(arr, xs, xn, ys, yn);
            func(arr, xn+1, xe, ys, yn);
            func(arr, xs, xn, yn+1, ye);
            func(arr, xn+1, xe, yn+1, ye);
        }
    }

    static int check(int[][] arr, int xs, int xe, int ys, int ye){
        int val = arr[ys][xs];
        for(int y = ys ; y <= ye; y++){
            for(int x = xs; x<= xe; x++ ){
                if(val != arr[y][x]){
                    return -1;
                }
            }
        }
        return val;
    }
}