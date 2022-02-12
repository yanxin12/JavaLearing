### Java Collector接口

---

## 1 内部枚举类Characteristics

### 1.1 概述

**知识收集器属性的特征类，用于优化归约实现**

```java
	/**
     * Characteristics indicating properties of a {@code Collector}, which can
     * be used to optimize reduction implementations.
     */
```

### 1.2 Characteristics 枚举类的五个属性

==CONCURRENT==

>收集器处于并发运行状态，同一个结果集可以支持不同累加器方法和多个线程

````java
		/**
         * Indicates that this collector is <em>concurrent</em>, meaning that
         * the result container can support the accumulator function being
         * called concurrently with the same result container from multiple
         * threads.
         *
         * <p>If a {@code CONCURRENT} collector is not also {@code UNORDERED},
         * then it should only be evaluated concurrently if applied to an
         * unordered data source.
         */		
````

==UNORDERED==

>无序状态，收集器无法保持输入数据的顺序

```java
 /**
 * Indicates that the collection operation does not commit to preserving
 * the encounter order of input elements.  (This might be true if the
 * result container has no intrinsic order, such as a {@link Set}.)
 */

```

==IDENTITY_FINISH==

>结束过程可以被省略，需要保证归约实现的过程中数据容器可以强制转化为结果容器

```
/**
 * Indicates that the finisher function is the identity function and
 * can be elided.  If set, it must be the case that an unchecked cast
 * from A to R will succeed.
 */
```

### 1.3 Collector（收集器）用到的五个无参方法

==supplier==

> 该方法返回一个`Supplier<A>`类型的结果，表示在计算过程中，如何初始化一个临时容器，比如A=List，那么一般返回ArrayList::new

==accumulator==

> 关键的计算逻辑都放在这里，定义了如何把一个个元素放入临时容器中，返回类型为`BiConsumer<A, T>`

==combiner==

> 返回一个`BinaryOperator<A>`类型的结果，个人理解是如何合并临时容器，但是在实际应用中没碰到执行过，所以一般直接返回null

==finisher== 

> 定义了如何把临时容器转换为输出结果，返回类型为`Function<A, R>`，需要注意的是，当方法`characteristics`的返回值中包含`Characteristics.IDENTITY_FINISH`，则必须保证从A到R能够强制转换成功，此时该方法固定返回`Function.identity()`即可。否则会报错。比如A为ArrayList，而R为HashMap的情况就会报错。









