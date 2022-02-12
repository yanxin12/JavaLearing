### Java PrimitiveIterator

---

## 1 概述

> 基本数据类型进行迭代的时候一般需要进行装箱，而装箱的操作会使得使用基本数据类型没有优势

```java
/**
// 基本数据类型的迭代器
 * A base type for primitive specializations of {@code Iterator}.  Specialized
 * subtypes are provided for {@link OfInt int}, {@link OfLong long}, and
 * {@link OfDouble double} values.
 *
 * <p>The specialized subtype default implementations of {@link Iterator#next}
 * and {@link Iterator#forEachRemaining(java.util.function.Consumer)} box
 * primitive values to instances of their corresponding wrapper class.  Such
 * boxing may offset any advantages gained when using the primitive
 * specializations.  To avoid boxing, the corresponding primitive-based methods
 * should be used.  For example, {@link PrimitiveIterator.OfInt#nextInt()} and
 * {@link PrimitiveIterator.OfInt#forEachRemaining(java.util.function.IntConsumer)}
 * should be used in preference to {@link PrimitiveIterator.OfInt#next()} and
 * {@link PrimitiveIterator.OfInt#forEachRemaining(java.util.function.Consumer)}.
 *
 * <p>Iteration of primitive values using boxing-based methods
 * {@link Iterator#next next()} and
 * {@link Iterator#forEachRemaining(java.util.function.Consumer) forEachRemaining()},
 * does not affect the order in which the values, transformed to boxed values,
 * are encountered.
 *
 * @implNote
 * If the boolean system property {@code org.openjdk.java.util.stream.tripwire}
 * is set to {@code true} then diagnostic warnings are reported if boxing of
 * primitive values occur when operating on primitive subtype specializations.
 *
 * @param <T> the type of elements returned by this PrimitiveIterator.  The
 *        type must be a wrapper type for a primitive type, such as
 *        {@code Integer} for the primitive {@code int} type.
 * @param <T_CONS> the type of primitive consumer.  The type must be a
 *        primitive specialization of {@link java.util.function.Consumer} for
 *        {@code T}, such as {@link java.util.function.IntConsumer} for
 *        {@code Integer}.
 *
 * @since 1.8
 */
```

## 1 Iterator父类

```java
public interface PrimitiveIterator<T, T_CONS> extends Iterator<T> 
```

## 2 forEachRemaining

>"Parameter behavior" and process into the each number of data

```java
 /**
 * Performs the given action for each remaining element, in the order
 * elements occur when iterating, until all elements have been processed
 * or the action throws an exception.  Errors or runtime exceptions
 * thrown by the action are relayed to the caller.
 *
 * @param action The action to be performed for each element
 * @throws NullPointerException if the specified action is null
 */
@SuppressWarnings("overloads")
void forEachRemaining(T_CONS action);
```

## 3 Interface OfInt( 内部接口)

**字符串类型是int类型？->实现了PrimitiveIterator迭代器**

**OfInt接口是一个Functional Interface 只有一个抽象方法nextInt**

****

```java
	 /**
     * An Iterator specialized for {@code int} values.
     * @since 1.8
     */
    public static interface OfInt extends PrimitiveIterator<Integer, IntConsumer> {

        /**
         * Returns the next {@code int} element in the iteration.
         *
         * @return the next {@code int} element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        int nextInt();

        /**
         * Performs the given action for each remaining element until all elements
         * have been processed or the action throws an exception.  Actions are
         * performed in the order of iteration, if that order is specified.
         * Exceptions thrown by the action are relayed to the caller.
         *
         * @implSpec
         * <p>The default implementation behaves as if:
         * <pre>{@code
         *     while (hasNext())
         *         action.accept(nextInt());
         * }</pre>
         *
         * @param action The action to be performed for each element
         * @throws NullPointerException if the specified action is null
         */
        default void forEachRemaining(IntConsumer action) {
            Objects.requireNonNull(action);
            while (hasNext())
                action.accept(nextInt());
        }

        /**
         * {@inheritDoc}
         * @implSpec
         * The default implementation boxes the result of calling
         * {@link #nextInt()}, and returns that boxed result.
         */
        @Override
        default Integer next() {
            if (Tripwire.ENABLED)
                Tripwire.trip(getClass(), "{0} calling PrimitiveIterator.OfInt.nextInt()");
            return nextInt();
        }

        // 如果传入的action范围大，但是可以被intConsumer继承，直接调用上面的forEachRemaining方法
        /**
         * {@inheritDoc}
         * @implSpec
         * If the action is an instance of {@code IntConsumer} then it is cast
         * to {@code IntConsumer} and passed to {@link #forEachRemaining};
         * otherwise the action is adapted to an instance of
         * {@code IntConsumer}, by boxing the argument of {@code IntConsumer},
         * and then passed to {@link #forEachRemaining}.
         */
        
        @Override
        default void forEachRemaining(Consumer<? super Integer> action) {
            if (action instanceof IntConsumer) {
                // 向下转型？
                forEachRemaining((IntConsumer) action);
            }
            else {
                // The method reference action::accept is never null
                Objects.requireNonNull(action);
                if (Tripwire.ENABLED)
                    Tripwire.trip(getClass(), "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
                forEachRemaining((IntConsumer) action::accept);
            }
        }

    }
```































