# Java Iterable接口

```
/**
 * Implementing this interface allows an object to be the target of
 * the "for-each loop" statement. See
 目标是为了实现增强for循环
 * <strong>
 * <a href="{@docRoot}/../technotes/guides/language/foreach.html">For-each Loop</a>
 * </strong>
 *
 * @param <T> the type of elements returned by the iterator
 *
 * @since 1.5
 * @jls 14.14.2 The enhanced for statement
 */
```

---

## 1 forEach

```java
/**
     * Performs the given action for each element of the {@code Iterable}
     // action是一个consumer接口（Lambda表达式表示动作）
     * until all elements have been processed or the action throws an
     * exception.  Unless otherwise specified by the implementing class,
     * actions are performed in the order of iteration (if an iteration order
     * is specified).  Exceptions thrown by the action are relayed to the
     * caller.
     *
     * @implSpec
     * <p>The default implementation behaves as if:
     * <pre>{@code
     *     for (T t : this)
     *         action.accept(t);
     * }</pre>
     *
     * @param action The action to be performed for each element
     * @throws NullPointerException if the specified action is null
     * @since 1.8
     */
	// 遍历集合中的每一个元素，并且使用Consumer接口消费每一个数据
    default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
```

## 2 iterator 方法

```java
  /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    Iterator<T> iterator();
```

## 3 Spliterator方法

```
/**
 * Creates a {@link Spliterator} over the elements described by this
 * {@code Iterable}.
 *
 * @implSpec
 * The default implementation creates an
 * <em><a href="Spliterator.html#binding">early-binding</a></em>
 * spliterator from the iterable's {@code Iterator}.  The spliterator
 * inherits the <em>fail-fast</em> properties of the iterable's iterator.
 *
 * @implNote
 * The default implementation should usually be overridden.  The
 * spliterator returned by the default implementation has poor splitting
 * capabilities, is unsized, and does not report any spliterator
 * characteristics. Implementing classes can nearly always provide a
 * better implementation.
 *
 * @return a {@code Spliterator} over the elements described by this
 * {@code Iterable}.
 * @since 1.8
 */
default Spliterator<T> spliterator() {
    return Spliterators.spliteratorUnknownSize(iterator(), 0);
}
```