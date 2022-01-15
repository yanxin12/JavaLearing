// -*- coding: utf-8 -*- 
/**
 * Project: InterfaceLearn
 * Creator: yanking
 * Create time: 2022-01-03 21:50
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package consumerInterfaceLearn;

import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class consumerInterfaceLearn {
    public void consumerString(Consumer<String> function) {
        function.accept("Hello");
    }

    @Test
    public void multiConsumer(String[] args) {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        printInfo(s -> System.out.print("姓名：" + s.split(",")[0]), // one
                s -> System.out.println("。性别：" + s.split(",")[1] + "。"), // two
                array);
    }

    // 根据输入的数据按照一定的数据处理步骤进行处理
    private void printInfo(Consumer<String> one, Consumer<String> two, String[] array) {
        for (String info : array) {
            one.andThen(two).accept(info); // 姓名：迪丽热巴。性别：女。
        }
    }

    // 学习Java 8 新增特性 ---- consumer 类
    @Test
    public void consumerElementOne() {
        Consumer<Integer> r = x -> {
            System.out.println(x + 1);
        };
        r.accept(10);
    }

    @Test
    public void consumerInterfaceT() {
        consumerString(s -> System.out.println(s + " world!"));
    }

    @Test
    public void consumerInterfaceMulti() {
    }


}
