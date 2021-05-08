package RangeQueries;
//fails in CSES due to slow Java :(
//works when translated to C++
import java.io.*;
import java.util.*;
public class BinaryIndexedTrees {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));//new File("test_input.txt"));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = Integer.parseInt(st.nextToken());
        FenwickTree ft = new FenwickTree(n);
        int q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) {
            ft.set(i+1, Integer.parseInt(st.nextToken()));
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int key = Integer.parseInt(st.nextToken());
            if (key == 1) ft.set(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            else out.println(ft.sum(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        f.close();
        out.close();
    }
    static class FenwickTree {
        int size;
        long[] bit;
        int[] arr;
        public FenwickTree(int n) {
            size = 1;
            while (size < n) size *= 2;
            bit = new long[size];
            arr = new int[size];
            Arrays.fill(bit, 0);
        }
        static int lsb(int i) {return i & -i;} //least significant bit
        public long sum(int a, int b) {
            return (a != 1) ? sum(b)-sum(a-1) : sum(b);
        }
        private long sum(int k) {
            long s = 0;
            k--;
            while (k >= 0) {
                s += bit[k];
                k -= lsb(k+1);
            }
            return s;
        }
        void set(int k, int x) {
            add(k, (int) (x-arr[k-1]));
            arr[k-1] = x;
        }
        void add(int k, int x) {
            k--;
            while (k < size) {
                bit[k] += x;
                k += lsb(k+1);
            }
        }
    }

}
