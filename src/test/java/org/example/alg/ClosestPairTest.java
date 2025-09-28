package org.example.alg;

import org.example.alg.util.Metrics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClosestPairTest {
    @Test
    public void smallBruteForceCompare() {
        Metrics m = new Metrics();
        int n = 200;
        ClosestPair.Point[] pts = new ClosestPair.Point[n];
        java.util.Random r = new java.util.Random(4);
        for (int i = 0; i < n; i++) pts[i] = new ClosestPair.Point(r.nextDouble()*1000, r.nextDouble()*1000);
        ClosestPair cp = new ClosestPair(m);
        double fast = cp.closest(pts);
        // brute force
        double brute = Double.POSITIVE_INFINITY;
        for (int i=0;i<n;i++) for (int j=i+1;j<n;j++) brute = Math.min(brute, Math.hypot(pts[i].x-pts[j].x, pts[i].y-pts[j].y));
        assertEquals(brute, fast, 1e-9);
    }
}
