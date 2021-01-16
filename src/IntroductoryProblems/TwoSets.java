package IntroductoryProblems;

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
            ArrayList<Integer> first = new ArrayList<>(Arrays.asList(1, 2));
            ArrayList<Integer> sec = new ArrayList<>(Arrays.asList(3));
            int x = 4;
            int sum1 = 3;
            int sum2 = 3;
            if (n%2==1){
                while (x <= n){
                    if (sum1 == sum2){
                        first.add(x);
                        sec.add(x+1);
                        x+=2;
                        sum1+=x;
                        sum2+=(x+1);
                    }
                    if (sum1 < sum2) {
                        first.add(x+1);
                        sec.add(x);
                        sum1+=(x+1);
                        sum2+=x;
                        x+=2;
                    }
                }
            }
            else{
                first = new ArrayList<>();
                sec = new ArrayList<>();
                boolean tag = true;
                for (int i = 1; i <= n/2; i++){
                    if (tag){
                        first.add(i);
                        first.add(n-i+1);
                    }
                    else{
                        sec.add(i);
                        sec.add(n-i+1);
                    }
                    tag = !tag;
                }
            }
            out.println(first.size());
            for (int i : first){
                out.print(i+" ");
            }
            out.println("\n"+sec.size());
            for (int i : sec){
                out.print(i+ " ");
            }
            out.println("");
        }
        else{
            out.println("NO");
        }

        f.close();out.close();
    }
}