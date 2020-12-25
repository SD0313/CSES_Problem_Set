import java.util.*;
import java.io.*;
public class PalindromeReorder{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        Map<Character, Integer> charCount = new HashMap<>();
        String s = f.readLine();
        for (char c : s.toCharArray()){
            if (!charCount.containsKey(c)){
                charCount.put(c, 0);
            }
            charCount.put(c, charCount.get(c)+1);
        }
        int numOdd = 0;
        char last = '1';
        for (char c: charCount.keySet()){
            if (charCount.get(c)%2==1) {
                numOdd++;
                last = c;
            }
        }
        if (numOdd > 1){
            out.println("NO SOLUTION");
        }
        else{
            String one = "";
            String two = "";
            for (char c : charCount.keySet()){
                if (c == last) continue;
                for (int i = 0; i < charCount.get(c)/2; i++){
                    one += c;
                    two = c+two;
                }
            }
            if (last != '1'){
                for (int i = 0; i < charCount.get(last)/2; i++){
                    one += last;
                    two = last+two;
                }
                one += last;
            }
            out.println(one+two);
        }


        f.close();out.close();
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}
    static int nextInt(BufferedReader f) throws IOException {return Integer.parseInt(f.readLine());}
}