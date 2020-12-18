import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TwoKnights{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        long n = Long.parseLong(f.readLine());
        for (long i = 1; i <= n; i++){
            out.println(answer(i));
        }
        f.close();out.close();
    }
    static long answer(long n){
        long term1 = ((n*n)*(n*n-1))/2;
        long term2 = 4*(n-1)*(n-2);
        return term1-term2;
    }

}
