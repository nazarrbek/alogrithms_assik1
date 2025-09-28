package org.example.alg;

import org.example.alg.util.Metrics;
import org.example.alg.ClosestPair.Point;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Metrics m = new Metrics();
        int n = 10000;
        if (args.length > 0) n = Integer.parseInt(args[0]);
        int[] a = new int[n];
        Random rnd = new Random(123);
        for (int i = 0; i < n; i++) a[i] = rnd.nextInt(n*10);

        // MergeSort example
        m.clear();
        MergeSort ms = new MergeSort(m);
        long t0 = System.nanoTime();
        ms.sort(a.clone());
        long t1 = System.nanoTime();
        System.out.println("MergeSort time ms: " + ((t1-t0)/1_000_000.0) + " depth: " + m.getMaxDepth());

        // QuickSort example
        m.clear();
        QuickSort qs = new QuickSort(m);
        t0 = System.nanoTime();
        qs.sort(a.clone());
        t1 = System.nanoTime();
        System.out.println("QuickSort time ms: " + ((t1-t0)/1_000_000.0) + " depth: " + m.getMaxDepth());

        // DeterministicSelect example (k = n/2)
        m.clear();
        DeterministicSelect ds = new DeterministicSelect(m);
        int[] ac = a.clone();
        t0 = System.nanoTime();
        int v = ds.select(ac, ac.length/2);
        t1 = System.nanoTime();
        System.out.println("Select median value: " + v + " time ms: " + ((t1-t0)/1_000_000.0) + " depth: " + m.getMaxDepth());

        // Closest pair example
        m.clear();
        Point[] pts = new Point[n];
        for (int i = 0; i < n; i++) pts[i] = new Point(rnd.nextDouble()*1000, rnd.nextDouble()*1000);
        ClosestPair cp = new ClosestPair(m);
        t0 = System.nanoTime();
        double d = cp.closest(pts);
        t1 = System.nanoTime();
        System.out.println("ClosestPair d: " + d + " time ms: " + ((t1-t0)/1_000_000.0) + " depth: " + m.getMaxDepth());
    }
}
