// -*- coding: utf-8 -*- 
/**
 * Project: InnerClass
 * Creator: yanking
 * Create time: 2021-08-11 14:42
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package chapter10Homework.templateTest;

public class B implements Job{
    @Override
    public void job() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 8000; i++) {
            sb.append("Hello");
        }

    }
}
