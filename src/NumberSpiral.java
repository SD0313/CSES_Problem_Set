import java.util.*;
import java.io.*;
public class NumberSpiral{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(f.readLine());
        for (int i = 0; i < t; i++){
            StringTokenizer st = new StringTokenizer(f.readLine());
            long row = nextLong(st);
            long col = nextLong(st);
            if (row >= col) {
                if (row%2==0){
                    out.println(row*row-(col-1));
                }
                else{
                    long start = (row-1)*(row-1)+1;
                    out.println(start+col-1);
                }
            }
            else {
                if (col%2==1) {
                    out.println(col*col-(row-1));
                }
                else {
                    long start = (col-1)*(col-1)+1;
                    out.println(start+row-1);
                }
            }
        }

        f.close();out.close();
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}
}