package org.example.alg;

import org.example.alg.util.Metrics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectTest {
    @Test
    public void selectMedian() {
        Metrics m = new Metrics();
        int[] a = new int[501];
        java.util.Random r = new java.util.Random(3);
        for (int i=0;i<a.length;i++) a[i]=r.nextInt(10000);
        int[] sorted = a.clone();
        java.util.Arrays.sort(sorted);
        int k = a.length/2;
        int expected = sorted[k];
        int got = new DeterministicSelect(m).select(a, k);
        assertEquals(expected, got);
    }
}
