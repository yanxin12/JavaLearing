// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-11 21:28
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.genThread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class main_ {
    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        Future<String> future = threadPool.submit((Callable<String>) (new ThreadUtils()));
       // Future<?> future2 = threadPool.submit((Runnable) (new ThreadUtils()));
        int i = 100;
        while (--i >= 0) {
            Thread.sleep(500);
            System.out.println(future.get());

        }
        // System.out.println(future2.get());
        threadPool.shutdown();
    }

    @Test
    public void singleCallableRun() throws Exception {
        System.out.println(new ThreadUtils().call());
    }
}
