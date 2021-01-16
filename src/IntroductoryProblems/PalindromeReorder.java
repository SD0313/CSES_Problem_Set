package IntroductoryProblems;

import java.util.*;
import java.io.*;
public class PalindromeReorder{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        String s = f.readLine();
        Map<Character, Boolean> start = new HashMap<>();
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()){
            if (!counts.containsKey(c)){
                counts.put(c, 0);
            }
            counts.put(c, counts.get(c)+1);
        }
        int numOdds = 0;
        StringBuilder odd = new StringBuilder();
        char oddChar = '1';
        for (char c : counts.keySet()){
            if (counts.get(c)%2==1) {
                numOdds++;
                oddChar = c;
                if (numOdds == 2){
                    out.println("NO SOLUTION");
                    out.close(); f.close();
                    return;
                }
                for (int i = 0; i < counts.get(c); i++){
                    odd.append(c);
                }
            }
        }
        StringBuilder one = new StringBuilder();
        StringBuilder two = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c == oddChar) continue;
            if (!start.containsKey(c)){
                start.put(c, true);
            }
            if (start.get(c)) {
                one.append(c);
                start.put(c, false);
            }
            else {
                two.insert(0, c);
                start.put(c, true);
            }

        }
        out.println(one.toString() +odd+two);
        f.close();out.close();
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}
    static int nextInt(BufferedReader f) throws IOException {return Integer.parseInt(f.readLine());}
}