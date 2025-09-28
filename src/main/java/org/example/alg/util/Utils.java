package org.example.alg.util;

import java.util.Random;

public class Utils {
    private static final Random R = new Random();

    public static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }

    public static void shuffle(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int j = R.nextInt(i + 1);
            swap(a, i, j);
        }
    }
}
