package IntroductoryProblems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Repetitions{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        String seq = f.readLine();
        char prev = '-';
        int max_len = -1;
        int curr_len = 0;
        for (char c : seq.toCharArray()){
            if (c == prev){
                curr_len++;
                max_len = Math.max(max_len, curr_len);
            }
            else{
                prev = c;
                max_len = Math.max(max_len, Math.max(curr_len, 1));
                curr_len = 1;
            }
        }
        out.println(max_len);

        f.close();out.close();
    }


}