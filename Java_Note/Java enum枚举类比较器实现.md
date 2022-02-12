### Java enum枚举类比较器实现

---

## 1 枚举类比较器

```java
class comparators{
    /**
     * Compares {@link Comparable} objects in natural order.
     *
     * @see Comparable
     */
    enum NaturalOrderComparator implements Comparator<Comparable<Object>> {
        INSTANCE;

        @Override
        public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            return c1.compareTo(c2);
        }

        @Override
        public Comparator<Comparable<Object>> reversed() {
            return Comparator.reverseOrder();
        }
    }
}
```

## 2 使用枚举类比较器

```java
/**
     * Returns a comparator that compares {@link Comparable} objects in natural
     * order.
     *
     * <p>The returned comparator is serializable and throws {@link
     * NullPointerException} when comparing {@code null}.
     *
     * @param  <T> the {@link Comparable} type of element to be compared
     * @return a comparator that imposes the <i>natural ordering</i> on {@code
     *         Comparable} objects.
     * @see Comparable
     * @since 1.8
     */
	// 枚举常量类似于实例化？ 
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
        return (Comparator<T>) Comparators.NaturalOrderComparator.INSTANCE;
    }
```

## 3 带字段枚举变量构造器简化写法

**可以省略定义String类型字段的步骤**

```
enum currency {
    YUAN("人民币：元"), DOLLARS("美元：刀"), GOLD("黄金：克");
    currency(String type) {
    }
}
缺点是无法显示输出具体的枚举变量信息
  System.out.printf(String.valueOf(transactions.currency.YUAN)); // YUAN
  System.out.printf(String.valueOf(transactions.currency.YUAN)); // currency{type='人民币：元'}
```

