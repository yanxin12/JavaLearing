### Java 8::Parameterizing the behavior 

---

// 将需要实现的方法作为参数返回

// 灵活使用接口

```java
	// accept()方法的妙用
    // parameterizing the behavior of print apple
 public interface appleFormatter {
        String accept(Apple a);
    }

```

```java
 public static void printPrettyApple(List<Apple> inventory, appleFormatter appleFormatter) {
        for (Apple apple : inventory) {
            String output = appleFormatter.accept(apple);
            System.out.println(output);
        }
    }


```

```java
  Apple.printPrettyApple(res, new Apple.appleFormatter() {
            @Override
            public String accept(Apple a) {
               // 自定义输出方法
                return "The Apple is" + a.getWeight() + "g.";
            }
        });
```

// 使用Consumer类中的accept方法

```java
// use the Consumer interface to realize the function of parameter the behavior
public static void printPrettyAppleT(List<Apple> inventory, Consumer<Apple> consumer) {
    for (Apple apple : inventory) {
        consumer.accept(apple);
    }
}
```

```java
 Apple.printPrettyAppleT(res, new Consumer<Apple>() {
            @Override
 public void accept(Apple apple) {
                System.out.println("Apple is " + apple.getColor());
            }
});

```



