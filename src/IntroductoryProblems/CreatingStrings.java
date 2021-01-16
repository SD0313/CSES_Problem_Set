package IntroductoryProblems;

import java.util.*;
import java.io.*;
public class CreatingStrings{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        String s = f.readLine();
        String[] arr = new String[s.length()];
        for (int i = 0 ;i < s.length(); i++){
            arr[i] = ""+s.charAt(i);
        }
        printAllRecursive(s.length(), arr, 'c');
        out.println(set.size());
        for (String str : set) {
            out.println(str);
        }
        f.close();out.close();
    }
    private static <T> void swap(T[] input, int a, int b) {
        T tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
    static Set<String> set = new TreeSet<>();
    private static <T> void printArray(T[] input) {
//        System.out.print('\n');
        String s = "";
        for(int i = 0; i < input.length; i++) {
            s+=input[i];
        }
        set.add(s);
    }
    public static <T> void printAllRecursive(
            int n, T[] elements, char delimiter) {

        if(n == 1) {
            printArray(elements);
        } else {
            for(int i = 0; i < n-1; i++) {
                printAllRecursive(n - 1, elements, delimiter);
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            printAllRecursive(n - 1, elements, delimiter);
        }
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}
    static int nextInt(BufferedReader f) throws IOException {return Integer.parseInt(f.readLine());}
}