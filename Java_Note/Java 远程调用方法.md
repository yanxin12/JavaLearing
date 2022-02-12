# Java 远程调用方法

---

## 1 RMI(Remote Method invocation)

-    JavaRMI即远程方法调用，是jdk中内嵌的一个最底层的解决方案，它应用起来最轻量级，也最简单，它不需要任何的web服务器，直接在代码中绑定IP地址和相应的端口，*适用于非常简单的小微应用*。

### 1.2 优点

- Full object support：RMI可将完整的对象作为参数和返回值进行传递，而不仅仅是预定义的数据类型。
- Cross platform：与java语言绑定，RMI只支持Java；
- Robust communications : 传输可靠
- Large objects：这个优点理解不深，粗略理解可传递大对象；
- Security for client and servers：RMI使用Java内置的安全机制保证下载执行程序时用户系统的安全。RMI使用专门为保护系统免遭恶意小程序侵害而设计的安全管理程序。
- Distribution/updates of codes：远程接口实际上就是Java接口，面向接口编程可轻松实现功能代码的升级；
- Design Mode:在传递对象的时候可以在解决方案的情况下使用面向对象设计模式

#### 1.3 缺点

- Java RMI only supports Java ： Java语言的远程调用，两端的程序语言必须是Java实现；
- Requires non-standard port ：  RMI对服务器的IP地址和端口依赖很紧密，但是在开发的时候不知道将来的服务器IP和端口如何，但是客户端程序依赖这个IP和端口。这也是RMI的局限性之一。这个问题有两种解决途径：一是通过DNS来解决，二是通过封装将IP暴露到程序代码之外。
- Proprietary protocol by single vendor ：RMI依赖于Java远程消息交换协议JRMP（Java Remote Messaging Protocol），该协议为java定制，要求服务端与客户端都为java编写；
- Requires RMI-lookup ： 需要注册(不明白为什么属于缺陷) 。







```java
下面是服务器端定义的方法的远程接口，客户端可以调用该方法。

import java.rmi.*;

public interface ExpenseServer extends Remote

{

    Policy getPolicy() throws RemoteException;

    void   submitReport(ExpenseReport report)

                throws RemoteException, InvalidReportException;

}

第一行import java的RMI包，所有的RMI类型都定义在包java.rmi或其子包内。接口ExpenseServer是一个标准的标准的java接口，其具备两个有趣的特征:

◆  从接口Remote派生，这表明该接口可以被远端调用。

◆  该接口的所有方法都抛出RemoteException异常，它被用来标识网络和消息传送失败。Remote方法可以掷出任何你喜欢的异常，但是它们至少必须掷出RemoteException异常，以便你可以处理那些只会在分布系统中才会产生的错误情况。这个接口本身支持两个方法：getPolicy返回一个实现Policy接口的对象，submitReport方法提交一个完成的报告，如果报告有任何错误，它将抛出一个异常。

    Policy接口本身宣布了一个方法，该方法用来检查客户端是可以把一个条目增加到报告中去。 

public interface Policy 

{

    void checkValid(ExpenseEntry entry)

        throws PolicyViolationException;

}

   如果条目是有效的，即其与当前政策是吻合的，该方法将正常返回，否则它将抛出一个描述错误类型的异常。Policy接口是本地的（非远端的），也就是说它将直接在客户端的虚拟机上运行，不需要通过网络，一个客户端的操作将是象这样的：

Policy curPolicy = server.getPolicy();

start a new expense report

show the GUI to the user

while (user keeps adding entries) 

{

try {

        curPolicy.checkValid(entry); // throws exception if not OK

        add the entry to the expense report

} 

catch (PolicyViolationException e) {

        show the error to the user

    }

}

server.submitReport(report);

当客户端调用客户端软件启动一个新的开支报告时，客户端调用服务器的Server.getPolicy方法请求服务器返回一个体现当前Policy的对象。每一个待添加的对象首先被提交给Policy对象去证明其合法性。如果Policy对象没有返回错误，该条目就可以增加到报告中，否则，错误将被反馈给用户，用户便可以依据其来采取正确的措施即时消除错误。当用户完成了对报告的添加后，整个报告将被提交，服务端代码类似下面这样：

import java.rmi.*;

import java.rmi.server.*;

class ExpenseServerImpl extends UnicastRemoteObject implements ExpenseServer

{

    ExpenseServerImpl() throws RemoteException {

        // ...set up server state...

    }

    public Policy getPolicy() {

        return new TodaysPolicy();

    }

    public void submitReport(ExpenseReport report) {

        // ...write the report into the db...

    }

}

除了基本的rmi包外，我们还导入了RMI.server包。类UnicastRemoteObject定义了当前服务的类型，在这个例子中是单例服务。Java类ExpenseServerImpl实现了远端接口ExpenseServer的方法。远端的客户主机可以用RMI发送消息给ExpenseServerImpl对象。

   这个例子里的重要方法是getPolicy，它仅仅返回一个定义当前Policy的对象。下面我们来看看一个Policy接口实现的例子：

  public class TodaysPolicy implements Policy {

    public void checkValid(ExpenseEntry entry)

         throws PolicyViolationException

    {

         if (entry.dollars() < 20) {

             return; // no receipt required

         } else if (entry.haveReceipt() == false) {

             throw new PolicyViolationException;

         }

    }

}

TodayPolicy 通过checkVailid方法来确保任何没有发票的条目都小于20美元，如果Policy明天发生了改变，其规定除了大于20美元的餐饮费外，其余都需要开发票，这时你可以提供一个新的Policy接口的实现：

 public class TomorrowsPolicy implements Policy {

    public void checkValid(ExpenseEntry entry)

         throws PolicyViolationException

    {

         if (entry.isMeal() && entry.dollars() < 20) {

             return; // no receipt required

         } else if (entry.haveReceipt() == false) {

             throw new PolicyViolationException;

         }

    }

}

写这个类，将其安装在服务器上，从而告知服务器从现在开始不再返回TodayPolicy对象，而是返回TomorrowsPolicy对象，由此你的整个系统将得到更新。当客户端调用服务器的getPolicy方法时，客户端的RMI将检查是否返回的是一个已知类型的对象。每个客户端第一次遇到一个TomorrowObject对象时，RMI将在getPolicy返回之前下载Policy新的实现，客户端不废一兵一卒即可使用新的对象。

RMI使用标准java对象序列化机制来传递对象，远端对象引用类型的参数将以远端引用来传递，如果方法的参数是基本类型或者局部类型（非远端），就将其拷贝传至服务器。返回值以同样方式进行处理，同时，在另一方面，RMI允许你返回对远端对象的引用。

在一个实际的系统中，getPolicy方法可能会设置一个参数来识别用户和开支报告（旅行，应酬等）的种类以便Policy可以进行区分。如果你不打算使用有差别的Policy和expense report对象，你可以使用一个newExtenseReport方法来直接返回一个检查Policy的ExpenseObject对象。这种策略将使你改变一个expense report的内容与修改一个Policy一样容易，如果哪一天公司决定把meals分割成breakfast，lunch，和dinner，改变起来将与上面所示修改一个Policy一样容易，你只需要写一个新类实现这个report，客户端然后可以自动使用它。
————————————————
版权声明：本文为CSDN博主「njchenyi」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/njchenyi/article/details/470210
```

