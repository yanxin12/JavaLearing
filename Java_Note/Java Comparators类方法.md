# Java Comparators类方法

---

==Java Comparators 类中只有两个内部类，两个内部类都实现了comparator接口==

```
// 是comparator接口的一个私有类，无法在接口之外实现comparators类的实例化
/**
 * Package private supporting class for {@link Comparator}.
 */
```

## Comparators类的两个内部类（都实现了comparator接口实现了对compare方法的重载）

==应为Comparators的两个类都实现了Compator接口，所以都可以作为比较器==

### 1 枚举类NaturalOrderComparator

```java
    /**
     * Compares {@link Comparable} objects in natural order.
     *
     * @see Comparable
     */
    enum NaturalOrderComparator implements Comparator<Comparable<Object>> {
        INSTANCE; // 枚举常量

        @Override// 比较的是是实现了Comparable接口的两个类，可以直接调用compareTo方法
        public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            return c1.compareTo(c2);
        }

        @Override
        public Comparator<Comparable<Object>> reversed() {
            // Comparator接口中的reverseOrder方法最终调用的是Collection类中的recerseOrder()			方法
            return Comparator.reverseOrder();
        }
    }
```



### 2 NullComparator类

```java
 	 /**
     * Null-friendly comparators
     */
    final static class NullComparator<T> implements Comparator<T>, Serializable {
        private static final long serialVersionUID = -7569533591570686392L;
        private final boolean nullFirst;
        // if null, non-null Ts are considered equal
        private final Comparator<T> real;

        @SuppressWarnings("unchecked")
        NullComparator(boolean nullFirst, Comparator<? super T> real) {
            this.nullFirst = nullFirst;
            this.real = (Comparator<T>) real;
        }

        @Override
        public int compare(T a, T b) {
            if (a == null) {
                return (b == null) ? 0 : (nullFirst ? -1 : 1);
            } else if (b == null) {
                return nullFirst ? 1: -1;
            } else {
                return (real == null) ? 0 : real.compare(a, b);
            }
        }

        @Override
        public Comparator<T> thenComparing(Comparator<? super T> other) {
            Objects.requireNonNull(other);
            return new NullComparator<>(nullFirst, real == null ? other : real.thenComparing(other));
        }

        @Override
        public Comparator<T> reversed() {
            return new NullComparator<>(!nullFirst, real == null ? null : real.reversed());
        }
    }
```

==比较器中必须有compare方法但是可以没有equals方法==

## 2  Comparator接口中的 equals方法

```java
	/**
     * Indicates whether some other object is &quot;equal to&quot; this
     * comparator.  This method must obey the general contract of
     * {@link Object#equals(Object)}.  Additionally, this method can return
     * <tt>true</tt> <i>only</i> if the specified object is also a comparator
     * and it imposes the same ordering as this comparator.  Thus,
     * <code>comp1.equals(comp2)</code> implies that <tt>sgn(comp1.compare(o1,
     * o2))==sgn(comp2.compare(o1, o2))</tt> for every object reference
     * <tt>o1</tt> and <tt>o2</tt>.<p>
     *
     * Note that it is <i>always</i> safe <i>not</i> to override
     * <tt>Object.equals(Object)</tt>.  However, overriding this method may,
     * in some cases, improve performance by allowing programs to determine
     * that two distinct comparators impose the same order.
     *
     * @param   obj   the reference object with which to compare.
     * @return  <code>true</code> only if the specified object is also
     *          a comparator and it imposes the same ordering as this
     *          comparator.
     * @see Object#equals(Object)
     * @see Object#hashCode()
     */
    boolean equals(Object obj);
```

Collection中的逆序比较器生成方法

```java
/**
     * Returns a comparator that imposes the reverse of the <em>natural
     * ordering</em> on a collection of objects that implement the
     * {@code Comparable} interface.  (The natural ordering is the ordering
     * imposed by the objects' own {@code compareTo} method.)  This enables a
     * simple idiom for sorting (or maintaining) collections (or arrays) of
     // 能够通过自定义比较器进行排序的类需要实现comparator接口
     * objects that implement the {@code Comparable} interface in
     * reverse-natural-order.  For example, suppose {@code a} is an array of
     * strings. Then: <pre>
     // 逆序排序比较器生成
     *          Arrays.sort(a, Collections.reverseOrder());
     * </pre> sorts the array in reverse-lexicographic (alphabetical) order.<p>
     *
     * The returned comparator is serializable.
     *
     * @param  <T> the class of the objects compared by the comparator
     * @return A comparator that imposes the reverse of the <i>natural
     *         ordering</i> on a collection of objects that implement
     *         the <tt>Comparable</tt> interface.
     * @see Comparable
     */
    @SuppressWarnings("unchecked")
    public static <T> Comparator<T> reverseOrder() {
        return (Comparator<T>) ReverseComparator.REVERSE_ORDER;
    }


REVERSE_ORDER常量：
    static final ReverseComparator REVERSE_ORDER
            = new ReverseComparator();


```

## 5 Collection类对reverse()方法的重载

```java
 @Override
        public Comparator<Comparable<Object>> reversed() {
            return Comparator.naturalOrder();
        }


```

## 6 comparators构造器

```java	
private Comparators() {
        throw new AssertionError("no instances");
    }
// 直接抛出断言异常，不允许直接实例化对象
// comparator接口直接实例化comparator的内部类
```

## 7 comparators类中的枚举类方法

```java
	/**
     * Compares {@link Comparable} objects in natural order.
     *
     * @see Comparable
     */

    enum NaturalOrderComparator implements Comparator<Comparable<Object>> {
        INSTANCE; // 枚举常量

        @Override // 对Comparator接口的方法进行重载
        public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            return c1.compareTo(c2);
        }

        @Override
        public Comparator<Comparable<Object>> reversed() {
            return Comparator.reverseOrder();
        }
    }

```

comparator接口中的reverseOrder方法

```java
    /**
     * Returns a comparator that imposes the reverse of the <em>natural
     * ordering</em>.
     *
     * <p>The returned comparator is serializable and throws {@link
     * NullPointerException} when comparing {@code null}.
     *
     * @param  <T> the {@link Comparable} type of element to be compared
     * @return a comparator that imposes the reverse of the <i>natural
     *         ordering</i> on {@code Comparable} objects.
     * @see Comparable
     * @since 1.8
     */
	// 最终调用了Collection中的reverseOrder()方法
    public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
        return Collections.reverseOrder();
    }

```

Collection中的reverseOrder方法

```java
 /**
     * Returns a comparator that imposes the reverse of the <em>natural
     * ordering</em> on a collection of objects that implement the
     * {@code Comparable} interface.  (The natural ordering is the ordering
     * imposed by the objects' own {@code compareTo} method.)  This enables a
     * simple idiom for sorting (or maintaining) collections (or arrays) of
     * objects that implement the {@code Comparable} interface in
     * reverse-natural-order.  For example, suppose {@code a} is an array of
     * strings. Then: <pre>
     // 可以直接用于数组排序
     
     *          Arrays.sort(a, Collections.reverseOrder());
     * </pre> sorts the array in reverse-lexicographic (alphabetical) order.<p>
     *
     * The returned comparator is serializable.
     *
     * @param  <T> the class of the objects compared by the comparator
     * @return A comparator that imposes the reverse of the <i>natural
     *         ordering</i> on a collection of objects that implement
     *         the <tt>Comparable</tt> interface.
     * @see Comparable
     */
    @SuppressWarnings("unchecked")
    public static <T> Comparator<T> reverseOrder() {
        return (Comparator<T>) ReverseComparator.REVERSE_ORDER;
    }

//  ReverseComparator是Collection类的一个内部类
//  REVERSE_ORDER是ReverseComparator中的一个常量，值就是对ReverseComparator类的实例化

 static final ReverseComparator REVERSE_ORDER
            = new ReverseComparator();

```

Collection中的compare方法

```java
    public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            return c2.compareTo(c1); // 因为c1和c2实现了Comparable接口，即重载了compareTo方法，所以这里使用了向上转型直接调用实现接口的方法，因为实现接口方法为抽象方法，所以最终会往子类寻找该方法，最终找到子类重载的compareTo方法；体现了接口的多态特性
        }
```

Collection中内部类reverseComparator

```java
  	/**
     * @serial include
     */
    private static class ReverseComparator
        implements Comparator<Comparable<Object>>, Serializable {

        private static final long serialVersionUID = 7207038068494060240L;

        static final ReverseComparator REVERSE_ORDER
            = new ReverseComparator(); // 单例设计模式，使用常量的方式实例化对象

        public int compare(Comparable<Object> c1, Comparable<Object> c2) {
            return c2.compareTo(c1);
        }			// c1.compareTo(c2) ->正常排序

        private Object readResolve() { return Collections.reverseOrder(); }

        @Override
        public Comparator<Comparable<Object>> reversed() {
            return Comparator.naturalOrder();
            // 逆序的逆序就是自然排序
        }
    }
```

Collection中的静态内部类ReverseComparator2

```java
	/**
     * @serial include
     */
    private static class ReverseComparator2<T> implements Comparator<T>,
        Serializable
    {
        // 显示声明序列化ID
        private static final long serialVersionUID = 4374092139857L;

        /**
         * The comparator specified in the static factory.  This will never
         * be null, as the static factory returns a ReverseComparator
         * instance if its argument is null.
         *
         * @serial
         */
           // 比较器常量，在初始化构造器的时候对比较器进行赋值
        final Comparator<T> cmp;

        ReverseComparator2(Comparator<T> cmp) {
            // 断言语句确保输入的比较器不为空
            assert cmp != null;
            this.cmp = cmp;
        }

        public int compare(T t1, T t2) {
            // 自定义了compare方法
            return cmp.compare(t2, t1);
        }

        public boolean equals(Object o) {
            return (o == this) ||
                (o instanceof ReverseComparator2 &&
                 cmp.equals(((ReverseComparator2)o).cmp));
        }

        public int hashCode() {
            return cmp.hashCode() ^ Integer.MIN_VALUE;
        }

        @Override
        public Comparator<T> reversed() {
            // 调用构造器的时候直接而初始化了比较器，比较器因此被赋值
            return cmp;
        }
    }
```

## 8 comparators中NullComparator类对compare方法的重载

```java
	@Override
        public int compare(T a, T b) {
            if (a == null) {
                return (b == null) ? 0 : (nullFirst ? -1 : 1);
            } else if (b == null) {
                return nullFirst ? 1: -1;
            } else {
                return (real == null) ? 0 : real.compare(a, b);
            }
        }
```

































