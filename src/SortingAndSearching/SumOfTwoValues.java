package SortingAndSearching;

import java.util.*;
import java.io.*;
//two pointers method implemented
public class SumOfTwoValues{
    static BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = nextInt(st);
        int x = nextInt(st);
        int[] arr = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++){
            arr[i] = nextInt(st);
            if (!map.containsKey(arr[i])){
                map.put(arr[i], new HashSet<>());
            }
            map.get(arr[i]).add(i+1);
        }
        Arrays.sort(arr);
        int p1 = 0;
        int p2 = n-1;
        while (p1 < p2){
            if (arr[p1]+arr[p2] < x){
                p1++;
            }
            else if (arr[p1] + arr[p2] > x){
                p2--;
            }
            else if (arr[p1] == arr[p2]){
                int count = 0;
                int out1 = 0;
                int out2 = 0;
                for (int i : map.get(arr[p1])){
                    if (count == 2) break;
                    count++;
                    if (count == 1) {
                        out1 = i;
                    }
                    if (count == 2){
                        out2 = i;
                    }
                }
                out.println(out1 + " " + out2);
                f.close(); out.close();
                return;
            }
            else if (arr[p1] != arr[p2]){
                int out1 = -1;
                for (int i : map.get(arr[p1])){
                    out1 = i;
                    map.get(arr[p1]).remove(i);
                }
                int out2 = -1;
                for (int i : map.get(arr[p2])){
                    out2 = i;
                    map.get(arr[p2]).remove(i);
                }
                out.println(out1+ " " + out2);
                f.close(); out.close();
                return;
            }
        }
//        int sum = arr[p1];

//        for (int i = 0; i < n; i++){
//
//            if (map.containsKey(x-arr[i])){
//                out.println((map.get(x-arr[i])+1) + " " + (i+1));
//                f.close(); out.close();
//                return;
//            }
//            map.put(arr[i], i);
//        }
        out.println("IMPOSSIBLE");
        f.close();out.close();
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}
    static int nextInt(BufferedReader f) throws IOException {return Integer.parseInt(f.readLine());}
}