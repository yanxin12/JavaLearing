// -*- coding: utf-8 -*- 
/**
 * Project: Rent_Sys
 * Creator: yanking
 * Create time: 2021-08-05 10:30
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package Template;

public class B extends Commom{
    @Override
    int job() {
        int s = 0;
        for (int i = 0; i < 3; i++) {
            s += i;
        }
        return s;
    }
}
