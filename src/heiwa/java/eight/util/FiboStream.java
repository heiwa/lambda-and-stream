package heiwa.java.eight.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * フィボナッチ数列を作る。
 */
public class FiboStream {
    static public Stream<BigInteger> fibo() {
        return Stream.iterate(new BigInteger[]{BigInteger.valueOf(0), BigInteger.valueOf(1)},
                a -> {
                    BigInteger tmp = a[1];
                    a[1] = a[0].add(a[1]);
                    a[0] = tmp;
                    return a;
                })
                .map(a -> a[0]);
    }
    static public BigInteger[] fiboNotStream(int limit) {
        if (limit < 1) { return null; }
        if (limit == 1) { return new BigInteger[]{BigInteger.valueOf(0)};}
        List<BigInteger> fibo = new ArrayList<>();
        fibo.add(BigInteger.valueOf(0));
        fibo.add(BigInteger.valueOf(1));
        for (int i=2; i<limit; i++) {
            fibo.add(fibo.get(i-1).add(fibo.get(i-2)));
        }
        return fibo.toArray(new BigInteger[0]);
    }
}
