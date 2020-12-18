import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class MissingNumber {
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        long n = Long.parseLong(f.readLine());
        long sum = (n*(n+1L))/2L;
        StringTokenizer st = new StringTokenizer(f.readLine());
        long thisSum = 0;
        for (int i = 0; i < n-1; i++){
            thisSum += Long.parseLong(st.nextToken());
        }
        out.println(sum-thisSum);
        f.close(); out.close();
    }
}
