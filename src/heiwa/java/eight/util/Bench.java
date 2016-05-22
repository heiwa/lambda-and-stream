package heiwa.java.eight.util;

import java.util.function.Supplier;

/**
 * ベンチマーク用クラス。
 */
public class Bench<T> {
    public long bench(Supplier<T> proc) {
        return bench(proc, 50_000);
    }
    public long bench(Supplier<T> proc, int count) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            proc.get();
        }
        return System.currentTimeMillis() - start;
    }
}
