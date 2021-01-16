package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class IncreasingArray{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        long n = Long.parseLong(f.readLine());
        long prev = -1;
        long turns = 0;
        StringTokenizer st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n ;i++){
            if (prev == -1){
                prev = Long.parseLong(st.nextToken());
            }
            else{
                long next = Long.parseLong(st.nextToken());
                if (prev > next) {
                    turns += prev-next;
                }
                prev = Math.max(prev, next);
            }
        }
        out.println(turns);
        f.close();out.close();
    }


}