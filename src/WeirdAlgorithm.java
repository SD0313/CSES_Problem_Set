import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class WeirdAlgorithm {
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        long n = Long.parseLong(f.readLine());
        algo(n);

        f.close(); out.close();
    }
    public static void algo(long n){
        System.out.print(n + " ");
        if (n == 1){
            return;
        }
        if (n%2 == 0){
            algo(n/2L);
        }
        else {
            algo(3L * n + 1L);
        }
    }
}
