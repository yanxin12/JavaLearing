// -*- coding: utf-8 -*- 
/**
 * Project: InterfaceLearn
 * Creator: yanking
 * Create time: 2022-01-04 10:38
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package JavaStreamInterfaceLearn.IntStream;

import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.stream.IntStream;




public class IntStream_Train {
    // 了解和练习Java中关于IntStream流的操作
    @Test
    public void shout() {
        // 包含指定整型的整型流
        IntStream intStream = IntStream.of(1);
        System.out.println(intStream);
        requireK("null");
    }
    @Test
    public void requireK(String k){
        Objects.requireNonNull(k);
        System.out.println(k);

    }

}
