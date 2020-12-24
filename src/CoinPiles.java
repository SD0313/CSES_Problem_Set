import java.util.*;
import java.io.*;
public class CoinPiles{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(f.readLine());
        for (int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            int a = nextInt(st);
            int b = nextInt(st);
            int count = 0;
            while (true) {
                if (a/b == 2){
                    count += Math.max(a/2, b/2);
                    break;
                }
                if (a > b) {
                    b -= 2;
                    a -= 1;
                }
                if (b > a){
                    a -= 2;
                    b -= 1;
                }
                count++;
            }
            out.println(count);
        }

        f.close();out.close();
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}

}