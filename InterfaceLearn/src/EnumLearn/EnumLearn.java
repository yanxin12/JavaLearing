// -*- coding: utf-8 -*- 
/**
 * Project: InterfaceLearn
 * Creator: yanking
 * Create time: 2022-01-04 20:56
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package EnumLearn;

import org.junit.jupiter.api.Test;

/*4 使用接口组织枚举*/
interface Food {
    enum dessert implements Food {
        CAKE, MOON, FRUITS;
    }

    enum fruits implements Food {
        APPLE("苹果"), ORANGE("橙子"), GAPE("葡萄");
        public String name;

        fruits(String name) {
            this.name = name;
        }
    }

}

public class EnumLearn {
    // 普通方法
    public static String getName2(int index) {
        for (Color color : Color.values()) { // enum.values()->获取枚举类中的常量
            if (index == color.index) {
                return color.name;
            }
        }
        return null;
    }

    /*2 优化switch语句*/
    public void method2(Color a) {
        switch (a) {
            case RED:
                System.out.println(Color.RED);
                break;
            case BLUE:
                System.out.println(Color.BLUE);
                break;
            case YELLOW:
                System.out.println(Color.YELLOW);
                break;
            default:
                System.out.println("Null");
        }
    }

    @Test
    public void shout() {
        System.out.println(Color.getName(2));
        System.out.println(getName2(2)); // 方法只能在枚举类中定义
    }

    @Test
    public void testEnum() {
        for (Food.fruits fruits : Food.fruits.values()) {
            System.out.println(fruits.name);
        }


    }

    /*枚举类常见用法*/
    /*1 创建常量*/
    /*3 在枚举类中添加新方法*/
    public enum Color {
        RED("红色", 1), YELLOW("黄色", 2), BLUE("蓝色", 1);
        // 成员变量
        public String name;
        public int index;

        // 当枚举类中的数据类型不是单一的数据的时候，需要给指定变量提供构造器
        // 不提供相应构造器则无法创建相应的常量
        Color(String name, int index) {
            this.name = name;
            this.index = index;
        }

        // 普通方法
        public static String getName(int index) {
            for (Color color : Color.values()) { // enum.values()->获取枚举类中的常量
                if (index == color.index) {
                    return color.name;
                }
            }
            return null;
        }

    }

}




