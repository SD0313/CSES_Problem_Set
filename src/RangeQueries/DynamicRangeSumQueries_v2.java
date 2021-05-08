/*********************************************************
 * Sauman Das
 * Successful for Codeforces "Segment Tree for the Sum"
 * May 6, 2021
 **********************************************************/

package RangeQueries;

import java.util.*;
import java.io.*;

public class DynamicRangeSumQueries_v2 {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
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
                int j = nextInt(st);
                int v = nextInt(st);
                segtree.set(j, v);
            }
            else {
                int l = nextInt(st);
                int r = nextInt(st);
                System.out.println(segtree.sum(l, r));
            }
        }
        f.close(); out.close();
    }
    static class SegmentTree {
        int size;
        long[] sums;
        public SegmentTree(int n) {
            size = 1;
            while (size <= n) size *= 2;
            sums = new long[2*size-1];
        }

        private void set(int i, int v, int x, int lx, int rx) {
            if (rx-lx == 1) {
                sums[x] = v;
                return;
            }
            int m = (lx+rx)/2;
            if (i < m) set(i, v, 2*x+1, lx, m);
            else set(i, v, 2*x+2, m, rx);
            sums[x] = sums[2*x+1] + sums[2*x+2];
        }

        public void set(int i, int v) {
            set(i, v, 0, 0, size);
        }

        private long sum(int l, int r) {
            return sum(l, r, 0, 0, size);
        }

        public long sum(int l, int r, int x, int lx, int rx) {
            if (lx >= r || l >= rx) return 0;
            if (lx >= l && rx <= r) return sums[x];
            int m = (lx+rx)/2;
            return sum(l, r, 2*x+1, lx, m) + sum(l, r, 2*x+2, m, rx);
        }
    }

    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}
    static int nextInt(BufferedReader f) throws IOException {return Integer.parseInt(f.readLine());}
}
