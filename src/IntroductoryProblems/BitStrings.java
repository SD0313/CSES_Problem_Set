package IntroductoryProblems;

import java.util.*;
import java.io.*;
public class BitStrings{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static final long MOD = (long) 1e9+7;
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(f.readLine());
        long curr = 1;
        for (int i = 0; i < n; i++){
            curr = (curr*2)%MOD;
        }
        out.println(curr);

        f.close();out.close();
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}

}