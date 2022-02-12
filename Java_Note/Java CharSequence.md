### Java CharSequence

---

## 1 概述

**CharSequence是一个可读的char类型的数据序列**

```java
/**
 * A <tt>CharSequence</tt> is a readable sequence of <code>char</code> values. This
 * interface provides uniform, read-only access to many different kinds of
 * <code>char</code> sequences.
 * A <code>char</code> value represents a character in the <i>Basic
 * Multilingual Plane (BMP)</i> or a surrogate. Refer to <a
 * href="Character.html#unicode">Unicode Character Representation</a> for details.
 *
 * <p> This interface does not refine the general contracts of the {@link
 * java.lang.Object#equals(java.lang.Object) equals} and {@link
 * java.lang.Object#hashCode() hashCode} methods.  The result of comparing two
 * objects that implement <tt>CharSequence</tt> is therefore, in general,
 * undefined.  Each object may be implemented by a different class, and there
 * is no guarantee that each class will be capable of testing its instances
 * for equality with those of the other.  It is therefore inappropriate to use
 * arbitrary <tt>CharSequence</tt> instances as elements in a set or as keys in
 * a map. </p>
 *
 * @author Mike McCloskey
 * @since 1.4
 * @spec JSR-51
 */

```

## 2 length

> **字符串长度**
>
> Char的数据使用16bit进行存储

```java
/**
 * Returns the length of this character sequence.  The length is the number
 * of 16-bit <code>char</code>s in the sequence.
 *
 * @return  the number of <code>char</code>s in this sequence
 */
int length();
```

## 3 charAt

// Extract the specific index char of a CharSequence

```
/**
 * Returns the <code>char</code> value at the specified index.  An index ranges from zero
 * to <tt>length() - 1</tt>.  The first <code>char</code> value of the sequence is at
 * index zero, the next at index one, and so on, as for array
 * indexing.
 *
 * <p>If the <code>char</code> value specified by the index is a
 * <a href="{@docRoot}/java/lang/Character.html#unicode">surrogate</a>, the surrogate
 * value is returned.
 *
 * @param   index   the index of the <code>char</code> value to be returned
 *
 * @return  the specified <code>char</code> value
 *
 * @throws  IndexOutOfBoundsException
 *          if the <tt>index</tt> argument is negative or not less than
 *          <tt>length()</tt>
 */
char charAt(int index);
```

## 4 subSequence("start","end")

>区间是一个左闭右开的区间
>
>方法返回指定区间的字符序列

```java
/**
 * Returns a <code>CharSequence</code> that is a subsequence of this sequence.
 * The subsequence starts with the <code>char</code> value at the specified index and
 * ends with the <code>char</code> value at index <tt>end - 1</tt>.  The length
 * (in <code>char</code>s) of the
 * returned sequence is <tt>end - start</tt>, so if <tt>start == end</tt>
 * then an empty sequence is returned.
 *
 * @param   start   the start index, inclusive
 * @param   end     the end index, exclusive
 *
 * @return  the specified subsequence
 *
 * @throws  IndexOutOfBoundsException
 *          if <tt>start</tt> or <tt>end</tt> are negative,
 *          if <tt>end</tt> is greater than <tt>length()</tt>,
 *          or if <tt>start</tt> is greater than <tt>end</tt>
 */
CharSequence subSequence(int start, int end);
```

## 5 default Char "流方法"

>方法内部迭代器的实现
>

```java
 	/**
     * Returns a stream of {@code int} zero-extending the {@code char} values
     * from this sequence.  Any char which maps to a <a
     * href="{@docRoot}/java/lang/Character.html#unicode">surrogate code
     * point</a> is passed through uninterpreted.
     *
     * <p>If the sequence is mutated while the stream is being read, the
     * result is undefined.
     *
     * @return an IntStream of char values from this sequence
     * @since 1.8
     */
    public default IntStream chars() {
        class CharIterator implements PrimitiveIterator.OfInt {
            int cur = 0;

            public boolean hasNext() {
                return cur < length();
            }

            public int nextInt() {
                if (hasNext()) {
                    return charAt(cur++);
                } else {
                    throw new NoSuchElementException();
                }
            }

            @Override
            public void forEachRemaining(IntConsumer block) {
                for (; cur < length(); cur++) {
                    block.accept(charAt(cur));
                }
            }
        }

        return StreamSupport.intStream(() ->
                Spliterators.spliterator(
                        new CharIterator(),
                        length(),
                        Spliterator.ORDERED),
                Spliterator.SUBSIZED | Spliterator.SIZED | Spliterator.ORDERED,
                false);
    }
```

