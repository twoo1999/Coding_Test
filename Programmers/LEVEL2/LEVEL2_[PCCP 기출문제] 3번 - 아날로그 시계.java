class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;

        int onTime12 = 12*3600;

        int time1 = h1 * 3600 + m1 * 60 + s1;
        int time2 = h2 * 3600 + m2 * 60 + s2;

        int time = time1;


        if(time1 == 0 || time == onTime12){
            answer++;
        }

        while (time < time2) {
            double hDeg = (time/(double)120) % 360;
            double mDeg = (time/(double)10) % 360;
            double sDeg = (time*6) % 360;

            double nhDeg = ((time+1)/(double)120) % 360;
            double nmDeg = ((time+1)/(double)10) % 360;
            double nsDeg = ((time+1)*6) % 360;

            if(nhDeg == 0) nhDeg = 360;
            if(nmDeg == 0) nmDeg = 360;
            if(nsDeg == 0) nsDeg = 360;

            if (hDeg > sDeg && nhDeg <= nsDeg) {
                answer++;
            }

            if (mDeg > sDeg && nmDeg <= nsDeg) {
                answer++;
            }
            if(nmDeg == nhDeg){
                answer--;
            }
            time++;
        }
        return answer;
    }
}