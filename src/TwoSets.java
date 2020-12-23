import java.util.*;
import java.io.*;
public class TwoSets{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(f.readLine());
        if (n%4==0 || (n+1)%4==0){
            out.println("YES");
            long sum = n*(n+1L)/4L;

        }
        else{
            out.println("NO");
        }

        f.close();out.close();
    }
}