package org.sushant.narrow_locks;

import java.util.List;
import java.util.stream.LongStream;

public class CacheFactorizer {
    private long lastNumber;
    private List<Long> lastFactors;
    private long hits;
    private long cacheHits;

    public synchronized long getHits() {
        return hits;
    }

    public synchronized double getHitRatio() {
        return (double) cacheHits / (double) hits;
    }

    public List<Long> getFactors(long number) {
        List<Long> factors;

        synchronized (this) {
            ++hits;
            if(number == lastNumber) {
                ++cacheHits;
                return lastFactors;
            }
        }

        factors = computeFactors(number);
        synchronized (this) {
            lastNumber = number;
            lastFactors = factors;
        }

        return factors;
    }

    private List<Long> computeFactors(long number) {
        return LongStream.rangeClosed(0, number / 2)
                .filter(i -> number % i == 0)
                .boxed()
                .toList();
    }
}
