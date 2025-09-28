package org.example.alg;

import org.example.alg.util.Metrics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {
    @Test
    public void sortRandom() {
        Metrics m = new Metrics();
        int[] a = new int[1000];
        java.util.Random r = new java.util.Random(2);
        for (int i=0;i<a.length;i++) a[i]=r.nextInt(10000);
        int[] expected = a.clone();
        java.util.Arrays.sort(expected);
        new QuickSort(m).sort(a);
        assertArrayEquals(expected, a);
    }
}
