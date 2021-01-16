package IntroductoryProblems;

import java.util.*;
import java.io.*;
public class TrailingZeros{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(f.readLine());
        int total = 0;
        for (int i = 1; i < 14; i++){
            total += Math.floor(n/Math.pow(5., i));
        }
        out.println(total);
        f.close();out.close();
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}

}