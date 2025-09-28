package org.example.alg;

import org.example.alg.util.Metrics;

public class MergeSort {
    private final Metrics m;

    public MergeSort(Metrics m) { this.m = m; }

    public void sort(int[] a) {
        int[] buf = new int[a.length];
        sort(a, buf, 0, a.length);
    }

    private void sort(int[] a, int[] buf, int l, int r) {
        m.enter();
        try {
            int n = r - l;
            if (n <= 16) { // insertion cutoff
                for (int i = l+1; i < r; i++) {
                    int key = a[i];
                    int j = i-1;
                    while (j >= l && a[j] > key) {
                        m.incComparisons(1);
                        a[j+1] = a[j];
                        j--;
                    }
                    a[j+1] = key;
                }
                return;
            }
            int mid = (l + r) >>> 1;
            sort(a, buf, l, mid);
            sort(a, buf, mid, r);
            // merge
            int i = l, j = mid, k = l;
            while (i < mid || j < r) {
                if (i < mid && (j >= r || a[i] <= a[j])) {
                    m.incComparisons(1);
                    buf[k++] = a[i++];
                } else {
                    if (j < r) m.incComparisons(1);
                    buf[k++] = a[j++];
                }
            }
            System.arraycopy(buf, l, a, l, n);
            m.incAllocations(n);
        } finally {
            m.exit();
        }
    }
}
