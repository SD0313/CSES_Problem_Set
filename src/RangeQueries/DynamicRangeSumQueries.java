package RangeQueries;

import java.util.*;
import java.io.*;

public class DynamicRangeSumQueries {
    static long[] segmentTree;
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(f.readLine());
        long n = nextLong(st);
        long q = nextLong(st);
        double log2 = Math.ceil(Math.log(n)/Math.log(2.));
        int newSize = (int) Math.pow(2, log2);
        long[] arr = new long[newSize];
        st = new StringTokenizer(f.readLine());
        int treeSize = (int) Math.pow(2, log2+1)-1;
        segmentTree = new long[treeSize];
        Arrays.fill(arr, -1);
        for (int i = 0; i < newSize; i++) {
            if (i < n) arr[i] = nextLong(st);
            segmentTree[treeSize-newSize+i] = arr[i];
        }
        buildTree(0);
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(f.readLine());
            boolean toUpdate = nextInt(st) == 1;
            if (toUpdate) {
                // Codeforces Code:
                int ind2update = treeSize-newSize+nextInt(st);
                // CSES Code:
//                int ind2update = treeSize-newSize+nextInt(st)-1;
                update(ind2update, nextLong(st)-segmentTree[ind2update]);
            }
            else {
                // CSES Code:
//                int start = nextInt(st)-1;//treeSize-newSize+nextInt(st)-1;
//                int end = nextInt(st);//treeSize-newSize+nextInt(st);
                // Codeforces Code:
                int start = nextInt(st);
                int end = nextInt(st);
                out.println(sum(0, start, end, 0, newSize));
            }
        }
//        out.println(Arrays.toString(segmentTree));
        f.close(); out.close();
    }
    static long sum(int x, int l, int r, int this_l, int this_r) {
        if (this_l >= l && this_r <= r) return segmentTree[x];
        if (this_r <= l || this_l >= r) return 0L;
//        if (l >= this_l && r <= this_r) return segmentTree[x];
        int mid = (this_l+this_r)/2;
        return sum(2*x+1, l, r, this_l, mid) + sum(2*x+2, l, r, mid, this_r);
    }
    static void update(int k, long inc) { //k is index, inc is increment amount
        segmentTree[k] += inc;
        if (k == 0) return;
        if (k % 2 == 0) update((k-2)/2, inc);
        else update((k-1)/2, inc);
    }
    static long buildTree(int x) {
        if (segmentTree[x] != 0) {
            return segmentTree[x];
        }
        segmentTree[x] = buildTree(2*x+1) + buildTree(2*x+2);
        return segmentTree[x];
    }
    static int nextInt(StringTokenizer st){return Integer.parseInt(st.nextToken());}
    static long nextLong(StringTokenizer st){return Long.parseLong(st.nextToken());}
    static int nextInt(BufferedReader f) throws IOException {return Integer.parseInt(f.readLine());}
}
