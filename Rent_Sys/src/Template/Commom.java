// -*- coding: utf-8 -*- 
/**
 * Project: Rent_Sys
 * Creator: yanking
 * Create time: 2021-08-05 10:31
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Template;

public abstract class Commom {
    abstract int job();
    public final void work(){
        long start = System.currentTimeMillis();
        System.out.println("开始时间： " + start);
        int result = job();
        long end = System.currentTimeMillis();
        System.out.println("结束时间： " + end);
        System.out.println("消耗时间： " + (end - start));
        System.out.println("计算结果为：" + result);

    }


}
