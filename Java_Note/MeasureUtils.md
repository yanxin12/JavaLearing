### MeasureUtils

---

```java
// This is a measure class to test a function's fastest running time
public long measurePerf(Function<Long, Long> adder, long n) {
    long fastest = Long.MAX_VALUE;
    long start = System.nanoTime();
    for (int i = 0; i < 10; i++) {
        long sum = adder.apply(n);
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Result:" + sum);
        if (duration < fastest) fastest = duration;
    }
    return fastest;
}
```