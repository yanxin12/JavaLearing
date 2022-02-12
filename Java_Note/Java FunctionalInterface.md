#### Java FunctionalInterface

---

//  存在且仅存在一个抽象方法的接口称为函数式接口

// 函数式接口的参数传递可以用匿名类也可以使用Lambda表达式，但是

当接口存在多个抽象方法的情况下只能使用匿名类



## 1  Callable<>

```java
/**
 * A task that returns a result and may throw an exception.
 * Implementors define a single method with no arguments called
 * {@code call}.
 *
 // 和Runable接口类似，用于实现线程创建，但是具有返回值
 * <p>The {@code Callable} interface is similar to {@link
 * java.lang.Runnable}, in that both are designed for classes whose
 * instances are potentially executed by another thread.  A
 * {@code Runnable}, however, does not return a result and cannot
 * throw a checked exception.
 *
 * <p>The {@link Executors} class contains utility methods to
 * convert from other common forms to {@code Callable} classes.
 *
 * @see Executor
 * @since 1.5
 * @author Doug Lea
 * @param <V> the result type of method {@code call}
 */
```

Callable抽象方法

// 相当于Runnable中的Run()方法，当时Run()方法具有返回值

```java
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    V call() throws Exception;
```

### 1.1 使用Callable 创建线程

````java
public class ThreadUtils implements Callable<String> {
    // 泛型String用于定义返回值的范围
    // 1 使用Callable接口创建线程
    @Override
    public String call() throws Exception {
        return "I am Callable Thread!";
    }
````

线程的运行

```java
    public static void main(String[] args) throws Exception {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        // 单线程需要提交到线程池进行运行
        Future<String> future = threadPool.submit((Callable<String>) (new ThreadUtils()));
        // Future<?> future2 = threadPool.submit((Runnable) (new ThreadUtils()));
        System.out.println(future.get());
        // System.out.println(future2.get());
        // 线程运行完毕需要关闭线程池
        threadPool.shutdown();
    }
```

## 2 Java Consumer 接口用法

// 获取一个数据并且返回一个操作

```java
 public void shout() {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        integers.forEach((a) -> System.out.println(a + "：hello!"));
        integers.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer + "：world");
            }
        });
    }
```

## 3  Java Function<R,T>接口的使用

// 接收一个类型的参数，返回另一个类型的参数

```java
public class FunctionInterfaceTrain {
    public static <S, R> List<R> map(List<S> list, Function<S, R> f) {
        ArrayList<R> res = new ArrayList<>();
        list.forEach(a -> res.add(f.apply(a)));
        return res;
    }
}
```

```java
public static void main(String[] args) {
        List<String> fruits = Arrays.asList("apple", "orange", "grape");
        List<Integer> res = FunctionInterfaceTrain.map(fruits, String::length);
        for (int i : res) {
            System.out.println(i);
        }
    }
```

### 3.2  Composed Function（构造复杂Function接口）

// Function接口的default方法可以实现复杂Function接口的实现

```java
    public void shout03() {
        // to construct a complicate function
        // Method Reference May Be The Best Way To Behavior The Parameter 
        Function<String, Integer> f1 = Integer::parseInt;
        Function<Integer, Double> f2 = Math::log;
        // The position of the two Fucntion means the f2 imoplement behind the f1
        Double res = f2.compose(f1).apply("100");
        System.out.println(res);
        Double res = f1.andThen(f2).apply("100");
        
    }
```

Function 接口中的andThen方法

```java
	/**
     * Returns a composed function that first applies this function to
     * its input, and then applies the {@code after} function to the result.
     * If evaluation of either function throws an exception, it is relayed to
     * the caller of the composed function.
     *
     * @param <V> the type of output of the {@code after} function, and of the
     *           composed function
     * @param after the function to apply after this function is applied
     * @return a composed function that first applies this function and then
     * applies the {@code after} function
     * @throws NullPointerException if after is null
     *
     * @see #compose(Function)
     */
    default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }	
```

// andThen运用

```java
addHeader + checkText + addTailer
the txt mush be checked between addHeader and addTailer
```

```java
Public class Letter{
    public static String addHeader(String text){
        return "Jack:" + text;        
    }
    public static String checkText(String text){
    	return text.replaceAll("labda","Lambda");   
    }
    public static String addTailer(String text){
        return text + "Kind regards";
    } 
}
```

// 方法调用

```java
public void shout04() {
        Function<String, String> addHeader = Letter::addHeader;
        Function<String, String> transFormationPipeLine =
                addHeader.andThen(Letter::checkText).andThen(Letter::addTailer);
    	// 这里的方法引用默认构造了对应的Function
        String res = Letter.connect("I am Jack,labda ", transFormationPipeLine);
        System.out.println(res);
}
```

### 3.3 使用Function接口表示数学公式

eg. Integrate(积分)

**As a side remark, it’s a bit of a shame that you have to write f.apply(a) instead of just f(a) as in mathematics, but Java just can’t get away from the view that everything is an object—instead of the idea of a function being truly independent**

```java
public double integrate(Function<Double,Double> f,double a,double b){
    return (f.apply(a) + f.apply(b)) * (b-a) / 2;
}
```



## 4  使用方法引用参数化行为

eg. String->Integer

```java
Lambda形式：Function<String,Integer> StringtoInteger = (String s)->IntegerParse(s);
方法引用形式：Function<String,Integer> StringtoInteger = Integer::IntegerParse;
```

eg2. List contains

``` java
BiPredicate<List<String>,String> contains = (list,element)->list.contains(element)
BiPredicate<List<String>,String> contains = List:::cintains
```



## 5 构造器的方法引用

// 使用方法引用实现实例化

```java
public void shout06() {
    // 使用方法引用实例化对象
    // 方法调用默认的无参构造器
    Supplier<People> people = People::new;
    System.out.println(people.get());
}

```

// 通过方法引用快速创建大量实例化对象

1 使用ClassName::new方法引用行为参数化

2 封装实例化方法

```java
public static<S,T> List<S> map<List<T> list,Function<T,S> f>{
   List<S> res =  new ArrayList<>();
    for(T t : list){
        res.add(f.apply(t));
    }
    return res;
} 
List weights =  Arrays.asList{2,3,4,5,6,7,8};
List<Apple> res = map(weights,Apple::new);

Apple::new ->自动匹配相应构造器，前提是数据类型需要相互对应
    weights数据类型对应为相应Filed构造器数据类型


```

使用方法引用实现多参数快速实例化方法

自定义接口构造

```java
// Construct a three reference interface inorder to construct instance
// Use parameter T t,U u,V v to construct R r
public interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}
```

方法构造

```java
// Use the Method Reference to Quickly Construct plenty of instance of three references
public static <S, U, T, D> List<D> mapT(S[] name, U[] color, T[] weights, TriFunction<S, U, T, D> tf) {
    ArrayList<D> res = new ArrayList<>();
    int len = name.length;
    for (int i = 0; i < len; i++) {
        res.add(tf.apply(name[i], color[i], weights[i]));
    }
    return res;
}
```

方法实现

```java
public void shout02() {
        // Construct multiInstances
        String[] name = {"RedApple", "YellowApple", "BlueApple"};
        // String[] Color = {"RED", "YELLOW", "BLUE"};
        // String[] Color = {color.YELLOW.getColor(),c};
        color[] colors = {color.YELLOW, color.BLUE, color.RED};
        Float[] weight = {8.8f, 6.6f, 9.9f};
        List<Apple> res = Apple.mapT(name, colors, weight, Apple::new);
        for (Apple apple : res) {
            System.out.println(apple);
        }
    }

```

## 6 Supplier接口

```java
/**
 * Represents a supplier of results.
 *产生的结果可能是一样的，即实例化对象可能是同一个
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 *
 * <p>This is a <a href="package-summary.html">functional interface</a>
 * whose functional method is {@link #get()}.
 *
 * @param <T> the type of results supplied by this supplier
 *
 * @since 1.8
 */
@FunctionalInterface
public interface Supplier<T> {

    /**
     * Gets a result.
     *
     * @return a result
     */
    T get();
}
```

































