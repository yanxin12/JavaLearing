Java Predicate类

---

>A interface that return type is boolean, when a function that need to a Predicate parameter,  you  can input a 
>
>function that return type is boolean 

## 1 test方法

// 其中Predicate类似于Lambda表达式

```java
   /**
     * Evaluates this predicate on the given argument.
     *
     * @param t the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    boolean test(T t);
	// 判断指定数据是否符合predicate表达式 
```

eg.

```java
public boolean checkPredict(name,Predicate<String> predicate){
   	return predicate(predicate.test(name));
}

public void static main(String[] args){
   Scanner myScanner = new Scanner(System.in);
   String name = myScanner.next();
   if(checkPredicate(name,(s)->{name.equals("jack")})){
       System.out.printlv("Your name is jack !");
   }
}
```

eg2.

```java
// or、and等方法,实现多条件判断
	/**
     * Returns a composed predicate that represents a short-circuiting logical
     * AND of this predicate and another.  When evaluating the composed
     * predicate, if this predicate is {@code false}, then the {@code other}
     * predicate is not evaluated.
     *
     * <p>Any exceptions thrown during evaluation of either predicate are relayed
     * to the caller; if evaluation of this predicate throws an exception, the
     * {@code other} predicate will not be evaluated.
     *
     * @param other a predicate that will be logically-ANDed with this
     *              predicate
     * @return a composed predicate that represents the short-circuiting logical
     * AND of this predicate and the {@code other} predicate
     * @throws NullPointerException if other is null
     */
    default Predicate<T> and(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) && other.test(t);
    }
	/**
     * Returns a composed predicate that represents a short-circuiting logical
     * OR of this predicate and another.  When evaluating the composed
     * predicate, if this predicate is {@code true}, then the {@code other}
     * predicate is not evaluated.
     *
     * <p>Any exceptions thrown during evaluation of either predicate are relayed
     * to the caller; if evaluation of this predicate throws an exception, the
     * {@code other} predicate will not be evaluated.
     *
     * @param other a predicate that will be logically-ORed with this
     *              predicate
     * @return a composed predicate that represents the short-circuiting logical
     * OR of this predicate and the {@code other} predicate
     * @throws NullPointerException if other is null
     */
    default Predicate<T> or(Predicate<? super T> other) {
        Objects.requireNonNull(other);
        return (t) -> test(t) || other.test(t);
    }
```

// 反向test

```java
  	/**
     * Returns a predicate that represents the logical negation of this
     * predicate.
     *
     * @return a predicate that represents the logical negation of this
     * predicate
     */
    default Predicate<T> negate() {
        return (t) -> !test(t);
    }
```

// equals判断

```java
    /**
     * Returns a predicate that tests if two arguments are equal according
     * to {@link Objects#equals(Object, Object)}.
     *
     * @param <T> the type of arguments to the predicate
     * @param targetRef the object reference with which to compare for equality,
     *               which may be {@code null}
     * @return a predicate that tests if two arguments are equal according
     * to {@link Objects#equals(Object, Object)}
     */
    static <T> Predicate<T> isEqual(Object targetRef) {
        return (null == targetRef)
                ? Objects::isNull
                : object -> targetRef.equals(object);
    }
```

**Predicate接口类似于一个方法声明，如果是已存在方法则需要是静态方法（Reference::Menthod）而且方法返回值必须是boolean类型**

// 简单过滤器方法实现

// 1 类撰写

```java
// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-11 10:45
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.referenceFunc;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Apple {
    private String name;
    private String color;
    private float weight;

    public Apple(String name, String color, float weight) {
        this.name = name;
        this.color = color;
        this.weight = weight;
    }

    public static List<Apple> filterApple(List<Apple> inventory, Predicate<Apple> p) {
        ArrayList<Apple> res = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                res.add(apple);
            }
        }

        return res;
    }

    public static boolean isGreenApple(Apple apple) {
        return "Green".equals(apple.getColor());
    }

    public static boolean isBigApple(Apple apple) {
        return apple.weight >= 10;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
    
// 如果在类中编写了Predicate接口，则后续不用导入java.util.function.Predicate接口
//    public interface Predicate<T> {
//        boolean test(T t);
//    }
}

```

// 方法调用

```java
// -*- coding: utf-8 -*- 
/**
 * Project: Java8InActionT
 * Creator: yanking
 * Create time: 2022-01-11 10:45
 * IDE: IntelliJ IDEA
 * Introduction:
 */
package com.referenceFunc;

import java.util.Arrays;
import java.util.List;

public class referenceFunc {
    public static void main(String[] args) {
        Apple apple1 = new Apple("紅蘋果", "Red", 15);
        Apple apple2 = new Apple("绿蘋果", "Green", 10);
        Apple apple3 = new Apple("蓝蘋果", "Blue", 8);
        Apple apple4 = new Apple("黄蘋果", "Yellow", 9);
        List<Apple> inventory = Arrays.asList(apple1, apple2, apple3, apple4);
        // 其中isBigApple需要是静态方法，否则无法使用，类似于->Apple.isBigApple()
        List<Apple> res = Apple.filterApple(inventory, Apple::isBigApple);
        for (Apple apple : res) {
            System.out.println(apple);
        }
    }
}

```

使用泛型将过滤器方法延伸

```java
    // Abstract the List Type beyond the problem domain
    public static <T> List<T> filter(List<T> inventory, Predicate<T> p) {
        ArrayList<T> res = new ArrayList<>();
        for (T t : inventory) {
            if (p.test(t)) {
                res.add(t);
            }
        }
        return res;
    }
```







