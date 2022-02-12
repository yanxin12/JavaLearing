# Java Comparator接口

---

## 1 nullsFirst

==返回一个对null友好的比较器，认为null小于非空值==

```java
	/**
     * Returns a null-friendly comparator that considers {@code null} to be
     * less than non-null. When both are {@code null}, they are considered
     * equal. If both are non-null, the specified {@code Comparator} is used
     * to determine the order. If the specified comparator is {@code null},
     * then the returned comparator considers all non-null values to be equal.
     *
     * <p>The returned comparator is serializable if the specified comparator
     * is serializable.
     *
     * @param  <T> the type of the elements to be compared
     * @param  comparator a {@code Comparator} for comparing non-null values
     * @return a comparator that considers {@code null} to be less than
     *         non-null, and compares non-null objects with the supplied
     *         {@code Comparator}.
     * @since 1.8
     */
    public static <T> Comparator<T> nullsFirst(Comparator<? super T> comparator) {
        return new Comparators.NullComparator<>(true, comparator);
    }
```

### 1.2 comparators内部类NullComparator

```java
	/**
     * Null-friendly comparators
     */
    final static class NullComparator<T> implements Comparator<T>, Serializable {
        // 显示表达序号化ID
        private static final long serialVersionUID = -7569533591570686392L;
        // 内部类属性值
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
                // 如果不传入比较器则系统不会对程序进行排序
                return (real == null) ? 0 : real.compare(a, b);
            }
        }

        @Override
        // 用于数据需要多维比较
        public Comparator<T> thenComparing(Comparator<? super T> other) {
            Objects.requireNonNull(other);
            return new NullComparator<>(nullFirst, real == null ? other : real.thenComparing(other));
        }

        @Override
        // 实现逆序比较
        public Comparator<T> reversed() {
            return new NullComparator<>(!nullFirst, real == null ? null : real.reversed());
        }
    }
```



### 1.3 nullsFirst使用方法

**Student类**

```java
public class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Student o) {
        return name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return name + "-" + age;
    }
}
```

```java
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class NullsFirstDemo {
  public static void main(String[] args) {
	Student s1 = new Student("Ram", 18);
	Student s2 = new Student("Shyam", 22);
	Student s3 = new Student("Mohan", 17);

	System.out.println("-------Case1: One null----------");

	List<Student> list = Arrays.asList(s1, s2, null, s3);
	Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(Student::getName)));
	list.forEach(s -> System.out.println(s));

	System.out.println("--------Case2: More than one null---------");

	list = Arrays.asList(s1, null, s2, null, s3);
	Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(Student::getName)));
	list.forEach(s -> System.out.println(s));

	System.out.println("--------Case3: Reverse specified Comparator to nullsFirst---------");

	list = Arrays.asList(s1, null, s2, null, s3);
	Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(Student::getName).reversed()));
	list.forEach(s -> System.out.println(s));

	System.out.println("--------Case4: Reverse Comparator returned by nullsFirst---------");

	list = Arrays.asList(s1, null, s2, null, s3);
	Collections.sort(list, Comparator.nullsFirst(Comparator.comparing(Student::getName)).reversed());
	list.forEach(s -> System.out.println(s));

	System.out.println("--------Case5: Specify natural order Comparator to nullsFirst---------");

	list = Arrays.asList(s1, null, s2, null, s3);
	Collections.sort(list, Comparator.nullsFirst(Comparator.naturalOrder()));
	list.forEach(s -> System.out.println(s));

	System.out.println("--------Case6: Specify null to nullsFirst---------");

	list = Arrays.asList(s1, null, s2, null, s3);
	Collections.sort(list, Comparator.nullsFirst(null));
	list.forEach(s -> System.out.println(s));
  }
} 

```

## 2 comparing方法（底层调用compareTo方法）

#### 2.1 只传入keyExtractor

```java
  /**
     * Accepts a function that extracts a {@link java.lang.Comparable
     * Comparable} sort key from a type {@code T}, and returns a {@code
     * Comparator<T>} that compares by that sort key.
     *
     * <p>The returned comparator is serializable if the specified function
     * is also serializable.
     *
     * @apiNote
     * For example, to obtain a {@code Comparator} that compares {@code
     * Person} objects by their last name,
     *
     * <pre>{@code
     *     Comparator<Person> byLastName = Comparator.comparing(Person::getLastName);
     * }</pre>
     *
     * @param  <T> the type of element to be compared
     * @param  <U> the type of the {@code Comparable} sort key
     * @param  keyExtractor the function used to extract the {@link
     *         Comparable} sort key
     * @return a comparator that compares by an extracted key
     * @throws NullPointerException if the argument is null
     * @since 1.8
     */
	// 这边不用直接传入比较器的原因是this数据类中的compareTo方法已经被重载了
	// 不需要在自定义比较器
    public static <T, U extends Comparable<? super U>> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor)
    {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
            // Lambda表达式，c1和c2的本类是实现了comparable接口的类，所以可以调用compareTo方法
            (c1, c2) -> keyExtractor.apply(c1).compareTo(keyExtractor.apply(c2));
    }
```

#### 2.2 传入自定义比较器

```java
 /**
     * Accepts a function that extracts a sort key from a type {@code T}, and
     * returns a {@code Comparator<T>} that compares by that sort key using
     * the specified {@link Comparator}.
     // 指定比较器
     * <p>The returned comparator is serializable if the specified function
     * and comparator are both serializable.
     *
     * @apiNote
     * For example, to obtain a {@code Comparator} that compares {@code
     * Person} objects by their last name ignoring case differences,
     *
     * <pre>{@code
     *     Comparator<Person> cmp = Comparator.comparing(
     *             Person::getLastName,
     *             String.CASE_INSENSITIVE_ORDER);
     * }</pre>
     *
     * @param  <T> the type of element to be compared
     * @param  <U> the type of the sort key
     * @param  keyExtractor the function used to extract the sort key
     // 排序值提取器
     * @param  keyComparator the {@code Comparator} used to compare the sort key
     // 排序值比较器
     * @return a comparator that compares by an extracted key using the
     *         specified {@code Comparator}
     // 只要有一个参数为空，则直接抛出空指针异常
     * @throws NullPointerException if either argument is null
     * @since 1.8
     */
	// 返回一个可序列化的比较器
    public static <T, U> Comparator<T> comparing(
            Function<? super T, ? extends U> keyExtractor,
            Comparator<? super U> keyComparator)
    {
        Objects.requireNonNull(keyExtractor);
        Objects.requireNonNull(keyComparator);
        return (Comparator<T> & Serializable)
            (c1, c2) -> keyComparator.compare(keyExtractor.apply(c1),
                                              keyExtractor.apply(c2));
    }

```

2.3 指定数据类型比较（int、long 、double）

```java

    /**
     * Accepts a function that extracts an {@code int} sort key from a type
     * {@code T}, and returns a {@code Comparator<T>} that compares by that
     * sort key.
     *
     * <p>The returned comparator is serializable if the specified function
     * is also serializable.
     *
     * @param  <T> the type of element to be compared
     * @param  keyExtractor the function used to extract the integer sort key
     * @return a comparator that compares by an extracted key
     * @see #comparing(Function)
     * @throws NullPointerException if the argument is null
     * @since 1.8
     */
    public static <T> Comparator<T> comparingInt(ToIntFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
            (c1, c2) -> Integer.compare(keyExtractor.applyAsInt(c1), keyExtractor.applyAsInt(c2));
    }

    /**
     * Accepts a function that extracts a {@code long} sort key from a type
     * {@code T}, and returns a {@code Comparator<T>} that compares by that
     * sort key.
     *
     * <p>The returned comparator is serializable if the specified function is
     * also serializable.
     *
     * @param  <T> the type of element to be compared
     * @param  keyExtractor the function used to extract the long sort key
     * @return a comparator that compares by an extracted key
     * @see #comparing(Function)
     * @throws NullPointerException if the argument is null
     * @since 1.8
     */
    public static <T> Comparator<T> comparingLong(ToLongFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
            (c1, c2) -> Long.compare(keyExtractor.applyAsLong(c1), keyExtractor.applyAsLong(c2));
    }

    /**
     * Accepts a function that extracts a {@code double} sort key from a type
     * {@code T}, and returns a {@code Comparator<T>} that compares by that
     * sort key.
     *
     * <p>The returned comparator is serializable if the specified function
     * is also serializable.
     *
     * @param  <T> the type of element to be compared
     * @param  keyExtractor the function used to extract the double sort key
     * @return a comparator that compares by an extracted key
     * @see #comparing(Function)
     * @throws NullPointerException if the argument is null
     * @since 1.8
     */
    public static<T> Comparator<T> comparingDouble(ToDoubleFunction<? super T> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (Comparator<T> & Serializable)
            (c1, c2) -> Double.compare(keyExtractor.applyAsDouble(c1), keyExtractor.applyAsDouble(c2));
    }
```

