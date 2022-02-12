Java BinaryOperator接口

---

## 1 概述

```java
 /**
 * Represents an operation upon two operands of the same type, producing a result
 * of the same type as the operands.  This is a specialization of
 * {@link BiFunction} for the case where the operands and the result are all of
 * the same type.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object, Object)}.
 *
 * @param <T> the type of the operands and result of the operator
 *
 * @see BiFunction
 * @see UnaryOperator
 * @since 1.8
 */
  public static <T> BinaryOperator<T> minBy(Comparator<? super T> comparator) {
        Objects.requireNonNull(comparator);
        return (a, b) -> comparator.compare(a, b) <= 0 ? a : b;
  }
```

## 2 Function

### 2.1 minBy

**传入比较器，根据比较方法返回逻辑小值**

```
 /**
 * Represents an operation upon two operands of the same type, producing a result
 * of the same type as the operands.  This is a specialization of
 * {@link BiFunction} for the case where the operands and the result are all of
 * the same type.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #apply(Object, Object)}.
 *
 * @param <T> the type of the operands and result of the operator
 *
 * @see BiFunction
 * @see UnaryOperator
 * @since 1.8
 */
```

### 2.2 maxBy

**传入比较器，返回逻辑大值**

```
/**
 * Returns a {@link BinaryOperator} which returns the greater of two elements
 * according to the specified {@code Comparator}.
 *
 * @param <T> the type of the input arguments of the comparator
 * @param comparator a {@code Comparator} for comparing the two values
 * @return a {@code BinaryOperator} which returns the greater of its operands,
 *         according to the supplied {@code Comparator}
 * @throws NullPointerException if the argument is null
 */
 
public static <T> BinaryOperator<T> maxBy(Comparator<? super T> comparator) {
    Objects.requireNonNull(comparator);
    return (a, b) -> comparator.compare(a, b) >= 0 ? a : b;
}
```