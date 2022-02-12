### Java DefaultFileSystemHolder类

---

### 1 加载器原理

>Java的类装载器是Java 动态性核心，Java虚拟机使用每一个类时的第一件事就是将该类的字节码装载进来，装载字节码的功能是由类装载起来完成的，类装载器负责根据一个类的名称类定位和生成类的字节码数据后返回给Java虚拟机。所以把类装载器描叙为类字节码的制造器更容易让人理解。
>
>Java虚拟机中内嵌了一个bootstrap的装载器，它是用来装载核心库中的类（即jdk/jre/lib/rt.jar文件中类）,Java核心包中有另外两个类装载器：ExtClassLoader和AppClassLoader,它们都是用java编写的java类，ExtClassLoader类装载器负责加载放在<JAVA_HOME>/jre/lib/ext目录下的jar包中了类，AppClassLoader负责加载应用程序的启动加载类。
>
>Java提供了抽象类ClassLoader，所有用户自定义类装载器都实例化自ClassLoader的子类。
>System Class Loader是一个特殊的用户自定义类装载器，由JVM的实现者提供，在编程者不特别指定装载器的情况下默认装载用户类。系统类装载器可以通过ClassLoader.getSystemClassLoader() 方法得到。 















































