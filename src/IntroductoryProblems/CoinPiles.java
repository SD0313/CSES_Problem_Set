package IntroductoryProblems;

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
            int max = Math.max(a, b);
            int min = Math.min(a, b);
            if ((a+b)%3 != 0 || max/2 > min){
                out.println("NO");
            }
            else{
                out.println("YES");
            }

        }

        f.close();out.close();
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}

}