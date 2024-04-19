import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        long n = num-1;
        long a= num+1;
        long d = num+1;
        System.out.println(n*(2*a+(n-1)*d)/2);
    }

}

