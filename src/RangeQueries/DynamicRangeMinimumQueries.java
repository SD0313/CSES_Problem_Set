package RangeQueries;

import java.io.*;
import java.util.*;

public class DynamicRangeMinimumQueries {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new FileReader("test_input_min.txt"));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(f.readLine());
        int n = nextInt(st);
        int q = nextInt(st);
        SegmentTree segtree = new SegmentTree(n);
        st = new StringTokenizer(f.readLine());
        for (int i = 0; i < n; i++) {
            segtree.set(i, nextInt(st));
        }
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            int key = nextInt(st);
            if (key == 1) {
                int j = nextInt(st)-1;
                int v = nextInt(st);
                segtree.set(j, v);
            }
            else {
                int l = nextInt(st)-1;
                int r = nextInt(st);
                System.out.println(segtree.min(l, r));
            }
        }
        f.close(); out.close();
    }
    static class SegmentTree {
        int size;
        long[] mins;
        public SegmentTree(int n) {
            size = 1;
            while (size <= n) size *= 2;
            mins = new long[2*size-1];
            Arrays.fill(mins, Long.MAX_VALUE);
        }

        private void set(int i, int v, int x, int lx, int rx) {
            if (rx-lx == 1) {
                mins[x] = v;
                return;
            }
            int m = (lx+rx)/2;
            if (i < m) set(i, v, 2*x+1, lx, m);
            else set(i, v, 2*x+2, m, rx);
            mins[x] = Math.min(mins[2*x+1], mins[2*x+2]);
        }

        public void set(int i, int v) {
            set(i, v, 0, 0, size);
        }

        private long min(int l, int r) {
            return min(l, r, 0, 0, size);
        }

        public long min(int l, int r, int x, int lx, int rx) {
            if (lx >= r || l >= rx) return Long.MAX_VALUE;
            if (lx >= l && rx <= r) return mins[x];
            int m = (lx+rx)/2;
            return Math.min(min(l, r, 2*x+1, lx, m), min(l, r, 2*x+2, m, rx));
        }
    }

    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}
    static int nextInt(BufferedReader f) throws IOException {return Integer.parseInt(f.readLine());}
}
