package org.example.alg;

import org.example.alg.util.Metrics;
import org.example.alg.util.Utils;
import java.util.Random;

public class QuickSort {
    private final Metrics m;
    private final Random rnd = new Random();

    public QuickSort(Metrics m) { this.m = m; }

    public void sort(int[] a) {
        Utils.shuffle(a);
        sortIterative(a, 0, a.length - 1);
    }

    // recurse on smaller part, iterate on larger to bound stack
    private void sortIterative(int[] a, int lo, int hi) {
        while (lo < hi) {
            m.enter();
            try {
                int p = partition(a, lo, hi);
                int leftSize = p - lo;
                int rightSize = hi - p;
                if (leftSize < rightSize) {
                    sortIterative(a, lo, p - 1);
                    lo = p + 1;
                } else {
                    sortIterative(a, p + 1, hi);
                    hi = p - 1;
                }
            } finally {
                m.exit();
            }
        }
    }

    private int partition(int[] a, int lo, int hi) {
        int pivotIndex = lo + rnd.nextInt(hi - lo + 1);
        int pivot = a[pivotIndex];
        swap(a, pivotIndex, hi);
        int i = lo;
        for (int j = lo; j < hi; j++) {
            m.incComparisons(1);
            if (a[j] < pivot) {
                swap(a, i++, j);
            }
        }
        swap(a, i, hi);
        m.incAllocations(1);
        return i;
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
