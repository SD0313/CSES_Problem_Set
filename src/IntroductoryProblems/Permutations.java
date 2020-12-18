package IntroductoryProblems;

import java.util.*;
import java.io.*;
public class Permutations{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    static int n;
    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(f.readLine());
        int[] seq = new int[n];
        if (n % 2 == 0){
            int ind = 0;
            for (int i = 2; i <= n; i+=2){
                seq[ind] = i;
                ind++;
            }
            for (int i = 1; i <= n-1; i+=2){
                if (seq[ind-1] - i == 1){
                    out.println("NO SOLUTION");
                    f.close();out.close();
                    return;
                }
                seq[ind] = i;
                ind++;
            }
        }
        if (n % 2 == 1){
            int ind = 0;
            for (int i = 1; i <= n; i+=2){
                seq[ind] = i;
                ind++;
            }
            for (int i = 2; i <= n-1; i+=2){
                if (seq[ind-1] - i == 1){
                    out.println("NO SOLUTION");
                    f.close();out.close();
                    return;
                }
                seq[ind] = i;
                ind++;
            }
        }
        for (int val : seq){
            out.print(val + " ");
        }
        f.close();out.close();
    }

}