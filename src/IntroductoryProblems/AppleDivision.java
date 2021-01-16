package IntroductoryProblems;

import java.util.*;
import java.io.*;
public class AppleDivision{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static long total = 0;
    public static void main(String[] args) throws IOException{
        int n = nextInt(f);
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++){
            int x = nextInt(st);
            arr[i] = x;
            total+=x;
        }
        leastDiff(arr, new HashSet<>(), 0);
        System.out.println(least);
        f.close();out.close();
    }
    static long least = Long.MAX_VALUE;

    static void leastDiff(int[] arr, Set<Long> inds, int sum){
        if (sum > total/2) return;
        System.out.println(inds);
        for (long i = 0; i < arr.length; i++){
            if (!inds.contains(i)){
                inds.add(i);
                least = Math.min(Math.abs(total-2*(sum+arr[(int)i])), least);
                leastDiff(arr, inds, sum+arr[(int)i]);
                inds.remove(i);
            }
        }
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}
    static int nextInt(BufferedReader f) throws IOException {return Integer.parseInt(f.readLine());}
}