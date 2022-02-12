### Java AccessController（访问控制类）

---

## 1 概述

==保护域==

> 保护域类被装入jvm，为每个类指定一个保护域，保护域定义了授予一段特定代码的所有权限，一个保护域对应一个策略policy.txt文件的一个或者多个grant子句，被装入jvm的每一个类型仅属于一个保护域。

>类装载器（ClassLoader）知道自己装载的所有类和接口的代码库和签名者，它利用这些信息生成CodeSource对象，将CodeSource对象传递给当前policy对象（policy对象代表了一个从代码来源到权限的全局映射，最终还是由类装载器负责决定代码执行时获取什么样权限）的getPermssions方法，得到PermissionCollection抽象类的子类实例，PermissionCollection包含所有Permission对象的引用，利用它创建的CodeSource和它从Policy对象得到的PermissionCollection，可以实例化一个新的保护域PretectDomain对象，然后传递给defineClass方法，来将这段代码放入保护域内。