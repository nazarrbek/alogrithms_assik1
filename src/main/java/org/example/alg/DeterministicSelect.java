package org.example.alg;

import org.example.alg.util.Metrics;

public class DeterministicSelect {
    private final Metrics m;

    public DeterministicSelect(Metrics m) { this.m = m; }

    public int select(int[] a, int k) {
        return select(a, 0, a.length - 1, k);
    }

    private int select(int[] a, int lo, int hi, int k) {
        m.enter();
        try {
            while (true) {
                if (lo == hi) return a[lo];
                int pivot = medianOfMedians(a, lo, hi);
                int p = partition(a, lo, hi, pivot);
                if (k == p) return a[p];
                else if (k < p) hi = p - 1;
                else lo = p + 1;
            }
        } finally {
            m.exit();
        }
    }

    private int partition(int[] a, int lo, int hi, int pivot) {
        int i = lo;
        int j = hi;
        while (i <= j) {
            while (i <= j && a[i] < pivot) { m.incComparisons(1); i++; }
            while (i <= j && a[j] > pivot) { m.incComparisons(1); j--; }
            if (i <= j) {
                int t = a[i]; a[i] = a[j]; a[j] = t;
                i++; j--;
            }
        }
        return i-1;
    }

    private int medianOfMedians(int[] a, int lo, int hi) {
        int n = hi - lo + 1;
        if (n <= 5) {
            java.util.Arrays.sort(a, lo, hi+1);
            return a[lo + n/2];
        }
        int numMedians = 0;
        for (int i = lo; i <= hi; i += 5) {
            int subHi = Math.min(i+4, hi);
            java.util.Arrays.sort(a, i, subHi+1);
            int median = a[i + (subHi - i)/2];
            a[lo + numMedians] = median;
            numMedians++;
        }
        // recurse to find median of medians
        return medianOfMedians(a, lo, lo + numMedians - 1);
    }
}
