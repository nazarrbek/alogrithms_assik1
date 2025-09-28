package org.example.alg.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Metrics {
    private final AtomicLong comparisons = new AtomicLong();
    private final AtomicLong allocations = new AtomicLong();
    private final AtomicInteger depth = new AtomicInteger();
    private final AtomicInteger maxDepth = new AtomicInteger();

    public void clear() {
        comparisons.set(0);
        allocations.set(0);
        depth.set(0);
        maxDepth.set(0);
    }

    public void incComparisons(long v) { comparisons.addAndGet(v); }
    public void incAllocations(long v) { allocations.addAndGet(v); }
    public void enter() {
        int d = depth.incrementAndGet();
        maxDepth.updateAndGet(m -> Math.max(m, d));
    }
    public void exit() {
        depth.decrementAndGet();
    }

    public long getComparisons() { return comparisons.get(); }
    public long getAllocations() { return allocations.get(); }
    public int getMaxDepth() { return maxDepth.get(); }

    public void writeCsv(String path, String line) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path, true))) {
            pw.println(line);
        }
    }
}
