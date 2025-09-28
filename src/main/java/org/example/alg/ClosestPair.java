package org.example.alg;

import org.example.alg.util.Metrics;
import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {
    private final Metrics m;

    public ClosestPair(Metrics m) { this.m = m; }

    public double closest(Point[] pts) {
        Point[] byX = pts.clone();
        Arrays.sort(byX, Comparator.comparingDouble(p -> p.x));
        Point[] aux = new Point[pts.length];
        return rec(byX, aux, 0, pts.length);
    }

    private double rec(Point[] a, Point[] aux, int l, int r) {
        m.enter();
        try {
            int n = r - l;
            if (n <= 3) {
                double best = Double.POSITIVE_INFINITY;
                for (int i = l; i < r; i++) for (int j = i+1; j < r; j++) {
                    best = Math.min(best, dist(a[i], a[j]));
                    m.incComparisons(1);
                }
                return best;
            }
            int mid = (l + r) >>> 1;
            double xm = a[mid].x;
            double dl = rec(a, aux, l, mid);
            double dr = rec(a, aux, mid, r);
            double d = Math.min(dl, dr);
            // merge by y into aux
            int i = l, j = mid, k = l;
            while (i < mid || j < r) {
                if (i < mid && (j >= r || a[i].y <= a[j].y)) aux[k++] = a[i++];
                else aux[k++] = a[j++];
            }
            System.arraycopy(aux, l, a, l, n);
            // build strip
            int cnt = 0;
            for (int t = l; t < r; t++) if (Math.abs(a[t].x - xm) < d) aux[cnt++] = a[t];
            for (int p = 0; p < cnt; p++) {
                for (int q = p+1; q < cnt && (aux[q].y - aux[p].y) < d; q++) {
                    d = Math.min(d, dist(aux[p], aux[q]));
                    m.incComparisons(1);
                }
            }
            m.incAllocations(n);
            return d;
        } finally {
            m.exit();
        }
    }

    private double dist(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.hypot(dx, dy);
    }

    public static class Point {
        public final double x,y;
        public Point(double x, double y){this.x=x;this.y=y;}
    }
}
